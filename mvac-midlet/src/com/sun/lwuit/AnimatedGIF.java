/*
 * Copyright (C) 2009 by Ugo Chirico All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the Lesser GNU General Public License, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the Lesser GNU General Public License
 * for more details
 *
 */

package com.sun.lwuit;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import com.sun.lwuit.Image;
import com.sun.lwuit.animations.Animation;

/**
 * Class AnimatedGIF - Implements an animated GIF image for LWUIT
 * <br>
 * Copyright (C) 2009 by Ugo Chirico All rights reserved
 * Please forward any corrections to ugos@<removethis>ugosweb.com.
 *
 * @author Ugo Chirico, http://www.ugosweb.com
 * @version 1.01 - 31 October 2009
 *
 */

public class AnimatedGIF extends Image implements Animation
{
    /**
     * The current frame doesn't point directly at the frames array since the first frame
     *  is the image itself
     */
    private int currentFrame;

    private long animationStartTime;
    private int totalAnimationTime;

    private int loop;
    private int loopCount;
    private Frame[] frames;

    private boolean enabled;
    /**
     * Returns the number of frames in the animation including the initial frame
     *
     * @return number of frames in the animation
     */
    public int getFrameCount() {
        // +1 for this image
        return frames.length;
    }

    /**
     * The time in which the given frame should appear
     *
     * @param frame must be a number bigger than -1 and smaller than getFrameCount()
     * @return the time in milliseconds for the frame to appear
     */
    public int getFrameTime(int frame) {
        if(frame == 0) {
            return 0;
        }
        return frames[frame].delay;
    }

    /**
     * Returns the duration for the entire animation used to determine when to loop
     * @return total animation time in milliseconds
     */
    public int getTotalAnimationTime() {
        return totalAnimationTime;
    }

    /**
     * Returns the RGB for the given frame, this method is relatively slow and
     * it is recommended that you do not use it for realtime animations.
     *
     * @param frame must be a number bigger than -1 and smaller than getFrameCount()
     * @return ARGB pixels within the given frame
     */
    public int[] getFrameRGB(int frame) {
        if(frame == 0) {
            return getRGBCached();
        }

        Image curFrame = frames[frame].frame;
//        int height = curFrame.getHeight();
//        int width = curFrame.getWidth();

        return curFrame.getRGB();
    }

    /**
     * Creates an animation from the given stream
     *
     * @param data input stream from which the animation is loaded
     * @return An instance of a static animation
     * @throws IOException when the stream throws it
     */
    public static AnimatedGIF createAnimatedGIF(InputStream data) throws IOException
    {
    	GifDecoder decoder = new GifDecoder();
    	decoder.read(data);

    	int totalTime = 0;
    	Frame frms[] = new Frame[decoder.getFrameCount()];
    	Frame frame;

    	for(int i = 0; i < frms.length; i++)
    	{
    		frame = new Frame();
    		frame.frame = new Image(decoder.getFrame(i));

    		frame.delay = decoder.getDelay(i);
    		totalTime += frame.delay;
    		frame.delay = totalTime;

    		frms[i] = frame;
    	}

    	return new AnimatedGIF(frms, decoder.getLoopCount(), totalTime);
    }

    protected AnimatedGIF( Frame frames[], int loopCount, int totalTime)
    {
    	super(frames[0].frame.getImage());
    	this.frames = frames;
    	this.loopCount = loopCount;
    	loop = loopCount;
    	totalAnimationTime = totalTime;
    	this.loopCount = loopCount;
    	enabled = true;
    }

    public boolean animate() {
    	if(!enabled)
    		return false;

        if(animationStartTime == 0) {
            animationStartTime = System.currentTimeMillis();
            return false;
        }
        long currentTime = System.currentTimeMillis();
        int position = (int)(currentTime - animationStartTime);
        if(loopCount == 0) {
            position %= totalAnimationTime;
        } else {
            if(position > totalAnimationTime && --loop < 0) {
                return false;
            }
        }

        // special case for last frame
        if(currentFrame == frames.length - 1) {
            if(position >= totalAnimationTime || position < frames[frames.length - 1].delay) {
                currentFrame = 0;
                animationStartTime = 0;
                return true;
            }
        } else {
            if(position >= frames[currentFrame].delay) {
                currentFrame++;
                if(currentFrame > frames.length + 1) {
                    currentFrame = 0;
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Restarts the animation
     */
    public void restart() {
    	if(loopCount > 0)
    		loop = loopCount;
        animationStartTime = System.currentTimeMillis();
    }

    /**
     * Starts the animation
     */
    public void start()
    {
    	enabled = true;
    	restart();
    }

    /**
     * Stops the animation
     */
    public void stop()
    {
    	enabled = false;
    }

    /**
     * @inheritDoc
     */
    public void paint(Graphics g) {
        drawImage(g, g.getGraphics(), 0, 0);
    }

    /**
     * Indicates whether the animation will run in a loop or run only once
     *
     * @return true for a loop animation
     */
    public boolean isLoop() {
        return loopCount == 0;
    }

    /**
     * Set whether the animation will run in a loop or run only once
     *
     * @param loop true for looping the animation
     */
    public void setLoop(boolean loop) {
        this.loopCount = loop ? 0 : 1;
    }

    /**
     * Set the loop counter of the animation
     *
     * @param loopCount 0 indicates infinite loop
     */
    public void setLoopCount(int loopCount) {
        this.loopCount = loop;
    }

    /**
     * @inheritDoc
     */
    protected void drawImage(Graphics g, Object nativeGraphics, int x, int y) {
        if(currentFrame == 0) {
            super.drawImage(g, nativeGraphics, x, y);
            return;
        }

        Image curImage = frames[currentFrame].frame;
        g.drawRGB(curImage.getRGB(), 0, x, y, getWidth(), getHeight(), true);
    }

    /**
     * @inheritDoc
     */
    public void scale(int width, int height) {
        AnimatedGIF s = (AnimatedGIF)scaled(width, height);
        setImage(s.getImage());
        frames = s.frames;
    }

    /**
     * @inheritDoc
     */
    public Image scaled(int width, int height) {
        int srcWidth = getWidth();
        int srcHeight = getHeight();

        // no need to scale
        if(srcWidth == width && srcHeight == height){
            return this;
        }

     	Frame frms[] = new Frame[frames.length];

     	for(int iter = 0 ; iter < frames.length ; iter++)
     	{
     		frms[iter] = new Frame();
     		frms[iter].frame = frames[iter].frame.scaled(width, height);
     		frms[iter].delay = frames[iter].delay;
     	}

        // scale the first frame
        AnimatedGIF result = new AnimatedGIF(frms, loopCount, totalAnimationTime);

        result.loop = loop;
        result.totalAnimationTime = totalAnimationTime;
        result.animationStartTime = animationStartTime;
        result.currentFrame = currentFrame;

        return result;
    }

    /**
     * @inheritDoc
     */
    public boolean isAnimation() {
        return frames.length > 1;
    }

    static class Frame
    {
    	Image frame;
    	int delay;
    }


    /**
     * Class GifDecoder - Decodes a GIF file into one or more frames.
     * <br><pre>
     * Example:
     *    GifDecoder d = new GifDecoder();
     *    d.read("sample.gif");
     *    int n = d.getFrameCount();
     *    for (int i = 0; i < n; i++) {
     *       BufferedImage frame = d.getFrame(i);  // frame i
     *       int t = d.getDelay(i);  // display duration of frame in milliseconds
     *       // do something with frame
     *    }
     * </pre>
     * No copyright asserted on the source code of this class.  May be used for
     * any purpose, however, refer to the Unisys LZW patent for any additional
     * restrictions.  Please forward any corrections to kweiner@fmsware.com.
     *
     * @author Kevin Weiner, FM Software; LZW decoder adapted from John Cristy's ImageMagick.
     * @version 1.03 November 2003
     *
     * @ Updated for use with J2ME by Tom Thompson, KPI Consulting, Inc. 15-Aug-2005
     */

    static class GifDecoder {

    	/**
    	 * File read status: No errors.
    	 */
    	public static final int STATUS_OK = 0;


    	/**
    	 * File read status: Error decoding file (may be partially decoded)
    	 */
    	public static final int STATUS_FORMAT_ERROR = 1;

    	/**
    	 * File read status: Unable to open source.
    	 */
    	public static final int STATUS_OPEN_ERROR = 2;

    	protected DataInputStream in;
    	protected int status;

    	protected int width; // full image width
    	protected int height; // full image height
    	protected boolean gctFlag; // global color table used
    	protected int gctSize; // size of global color table
    	protected int loopCount = 1; // iterations; 0 = repeat forever

    	protected int[] gct; // global color table
    	protected int[] lct; // local color table
    	protected int[] act; // active color table

    	protected int bgIndex; // background color index
    	protected int bgColor; // background color
    	protected int lastBgColor; // previous bg color
    	protected int pixelAspect; // pixel aspect ratio

    	protected boolean lctFlag; // local color table flag
    	protected boolean interlace; // interlace flag
    	protected int lctSize; // local color table size

    	protected int ix, iy, iw, ih; // current image rectangle
    	protected int lx, ly, lw, lh; // last image rect
    	protected static javax.microedition.lcdui.Image imageData; // current frame
    	protected static javax.microedition.lcdui.Image lastImage; // previous frame

    	protected byte[] block = new byte[256]; // current data block
    	protected int blockSize = 0; // block size

    	// last graphic control extension info
    	protected int dispose = 0;
    	// 0=no action; 1=leave in place; 2=restore to bg; 3=restore to prev
    	protected int lastDispose = 0;
    	protected boolean transparency = true; // use transparent color
    	protected int delay = 0; // delay in milliseconds
    	protected int transIndex; // transparent color index

    	protected static final int MaxStackSize = 4096;
    	// max decoder pixel stack size

    	// LZW decoder working arrays
    	protected short[] prefix;
    	protected byte[] suffix;
    	protected byte[] pixelStack;
    	protected byte[] pixels;

        protected int [] dest;
        protected int [] prev;

        protected Vector frames; // For J2ME - frames read from current file
    	protected int frameCount;

    	static class GifFrame {
    		public GifFrame(javax.microedition.lcdui.Image image, int del) {
    			this.image = image;
    			this.delay = del;
    		}
    		public javax.microedition.lcdui.Image image;
    		public int delay;
    	}

    	/**
    	 * Gets display duration for specified frame.
    	 *
    	 * @param n int index of frame
    	 * @return delay in milliseconds
    	 */
    	public int getDelay(int n) {
    		//
    		delay = -1;
    		if ((n >= 0) && (n < frameCount)) {
    			delay = ((GifFrame) frames.elementAt(n)).delay;
    		}
    		return delay;
    	}

    	/**
    	 * Gets the number of frames read from file.
    	 * @return frame count
    	 */
    	public int getFrameCount() {
    		return frameCount;
    	}

    	/**
    	 * Gets the first (or only) image read.
    	 *
    	 * @return BufferedImage containing first frame, or null if none.
    	 */
//    	public BufferedImage getImage() {
    	public javax.microedition.lcdui.Image getImage() {
    		return getFrame(0);
    	}

    	/**
    	 * Gets the "Netscape" iteration count, if any.
    	 * A count of 0 means repeat indefinitiely.
    	 *
    	 * @return iteration count if one was specified, else 1.
    	 */
    	public int getLoopCount() {
    		return loopCount;
    	}

    	/**
    	 * Creates new frame image from current data (and previous
    	 * frames as specified by their disposition codes).
    	 */
    	protected void setPixels() {
                // expose destination image's pixels as int array
                try{
                    dest = new int[width * height];
    			imageData.getRGB(dest, 0, width, 0, 0, width, height);
                } catch (Exception ex) {
                        System.out.println("setPixel error - " + ex.toString());
                } // end catch

    // Fill in starting image's contents based on last image's dispose code
                if (lastDispose > 0) {
                    if (lastDispose == 3) {     // use image before last
                        int n = frameCount - 2;
                        if (n > 0) {
                            lastImage = getFrame(n - 1);
                        } else {
                            lastImage = null;
                        }
                    } // end if lastDispose == 3

                    if (lastImage != null) {
//                      int[] prev =
//    			((DataBufferInt) lastImage.getRaster().getDataBuffer()).getData();
                        try {
                            prev = new int[width * height];
                            lastImage.getRGB(prev, 0, width, 0, 0, width, height);
                        } catch (Exception ex) {
                        System.out.println("setPixel error - " + ex.toString());
                        } // end catch

                        System.arraycopy(prev, 0, dest, 0, width * height); // copy pixels

    // fill last image rect area with background color
    /**/                if (lastDispose == 2) {
    /**/                    int c = 0;
    /**/                    if (!transparency) {
    /**/                        c = lastBgColor;
    /**/                    } // end if
    /**/                    for (int i = 0; i < lh; i++) {  // Use previous image dimensions
    /**/                        int n1 = (ly+i) * width + lx;
    /**/                        int n2 = n1 + lw;
    /**/                        for (int k = n1; k < n2; k++) { // Copy background color
    /**/                            dest[k] = c;
    /**/                        } // end for
    /**/                    } // end for
    /**/                } // end if lastDipose == 2
    /**/            } // end lastImage != null
                } // end if lastDispose > 0

    // copy each source line to the appropriate place in the destination
    		int pass = 1;
    		int inc = 8;
    		int iline = 0;
    		for (int i = 0; i < ih; i++) {
    			int line = i;
    			if (interlace) {
    				if (iline >= ih) {
    					pass++;
    					switch (pass) {
    						case 2 :
    							iline = 4;
    							break;
    						case 3 :
    							iline = 2;
    							inc = 4;
    							break;
    						case 4 :
    							iline = 1;
    							inc = 2;
    					}
    				}
    				line = iline;
    				iline += inc;
    			}
    			line += iy;
    			if (line < height) {
    				int k = line * width;
    				int dx = k + ix; // start of line in dest
    				int dlim = dx + iw; // end of dest line
    				if ((k + width) < dlim) {
    					dlim = k + width; // past dest edge
    				}
    				int sx = i * iw; // start of line in source
    				while (dx < dlim) {
    					// map color and insert in destination
    					int index = ((int) pixels[sx++]) & 0xff;
    					int c = act[index];
    					if (c != 0) {
    						dest[dx] = c;
    					}
    					dx++;
    				} // end while
    			} // end if
    		} // end for
                    imageData = javax.microedition.lcdui.Image.createRGBImage(dest, width, height, false) ;
    	} // end setPixels()

    	/**
    	 * Gets the image contents of frame n.
    	 *
    	 * @return BufferedImage representation of frame, or null if n is invalid.
    	 */
    	public javax.microedition.lcdui.Image getFrame(int n) {
    		javax.microedition.lcdui.Image im = null;
    		if ((n >= 0) && (n < frameCount)) {
    			im = ((GifFrame) frames.elementAt(n)).image;
            }
    		return im;
    	}

    	/**
    	 * Reads GIF image from stream
    	 *
    	 * @param BufferedInputStream containing GIF file.
    	 * @return read status code (0 = no errors)
    	 */
    	public int read(DataInputStream is) {
    		init();
    		if (is != null) {
    			in = is;
    			readHeader();
    			if (!err()) {
    				readContents();
    				if (frameCount < 0) {
    					status = STATUS_FORMAT_ERROR;
    				}
    			}
    		} else {
    			status = STATUS_OPEN_ERROR;
    		}
    		try {
    			is.close();
    		} catch (IOException e) {
    		}
    		return status;
    	}

    	/**
    	 * Reads GIF image from stream
    	 *
    	 * @param InputStream containing GIF file.
    	 * @return read status code (0 = no errors)
    	 */
    	public int read(InputStream is) {
    		init();
    		if (is != null) {
    			if (!(is instanceof DataInputStream))
    				in = new DataInputStream(is);
    			readHeader();
    			if (!err()) {
    				readContents();
    				if (frameCount < 0) {
    					status = STATUS_FORMAT_ERROR;
    				}
    			}
    		} else {
    			status = STATUS_OPEN_ERROR;
    		}
    		try {
    			is.close();
    		} catch (IOException e) {
    		}
    		return status;
    	}

    	/**
    	 * Decodes LZW image data into pixel array.
    	 * Adapted from John Cristy's ImageMagick.
    	 */
    	protected void decodeImageData() {
    		int NullCode = -1;
    		int npix = iw * ih;
    		int available,
    			clear,
    			code_mask,
    			code_size,
    			end_of_information,
    			in_code,
    			old_code,
    			bits,
    			code,
    			count,
    			i,
    			datum,
    			data_size,
    			first,
    			top,
    			bi,
    			pi;

    		if ((pixels == null) || (pixels.length < npix)) {
    			pixels = new byte[npix]; // allocate new pixel array
    		}
    		if (prefix == null) prefix = new short[MaxStackSize];
    		if (suffix == null) suffix = new byte[MaxStackSize];
    		if (pixelStack == null) pixelStack = new byte[MaxStackSize + 1];

    		//  Initialize GIF data stream decoder.

    		data_size = read();
    		clear = 1 << data_size;
    		end_of_information = clear + 1;
    		available = clear + 2;
    		old_code = NullCode;
    		code_size = data_size + 1;
    		code_mask = (1 << code_size) - 1;
    		for (code = 0; code < clear; code++) {
    			prefix[code] = 0;
    			suffix[code] = (byte) code;
    		}

    		//  Decode GIF pixel stream.

    		datum = bits = count = first = top = pi = bi = 0;

    		for (i = 0; i < npix;) {
    			if (top == 0) {
    				if (bits < code_size) {
    					//  Load bytes until there are enough bits for a code.
    					if (count == 0) {
    						// Read a new data block.
    						count = readBlock();
    						if (count <= 0)
    							break;
    						bi = 0;
    					}
    					datum += (((int) block[bi]) & 0xff) << bits;
    					bits += 8;
    					bi++;
    					count--;
    					continue;
    				}

    				//  Get the next code.

    				code = datum & code_mask;
    				datum >>= code_size;
    				bits -= code_size;

    				//  Interpret the code

    				if ((code > available) || (code == end_of_information))
    					break;
    				if (code == clear) {
    					//  Reset decoder.
    					code_size = data_size + 1;
    					code_mask = (1 << code_size) - 1;
    					available = clear + 2;
    					old_code = NullCode;
    					continue;
    				}
    				if (old_code == NullCode) {
    					pixelStack[top++] = suffix[code];
    					old_code = code;
    					first = code;
    					continue;
    				}
    				in_code = code;
    				if (code == available) {
    					pixelStack[top++] = (byte) first;
    					code = old_code;
    				}
    				while (code > clear) {
    					pixelStack[top++] = suffix[code];
    					code = prefix[code];
    				}
    				first = ((int) suffix[code]) & 0xff;

    				//  Add a new string to the string table,

    				if (available >= MaxStackSize)
    					break;
    				pixelStack[top++] = (byte) first;
    				prefix[available] = (short) old_code;
    				suffix[available] = (byte) first;
    				available++;
    				if (((available & code_mask) == 0)
    					&& (available < MaxStackSize)) {
    					code_size++;
    					code_mask += available;
    				}
    				old_code = in_code;
    			}

    			//  Pop a pixel off the pixel stack.

    			top--;
    			pixels[pi++] = pixelStack[top];
    			i++;
    		}

    		for (i = pi; i < npix; i++) {
    			pixels[i] = 0; // clear missing pixels
    		}

    	}

    	/**
    	 * Returns true if an error was encountered during reading/decoding
    	 */
    	protected boolean err() {
    		return status != STATUS_OK;
    	}

    	/**
    	 * Initializes or re-initializes reader
    	 */
    	protected void init() {
    		status = STATUS_OK;
    		frameCount = 0;
//    		frames = new ArrayList();
    		frames = new Vector();
    		gct = null;
    		lct = null;
    	}

    	/**
    	 * Reads a single byte from the input stream.
    	 */
    	protected int read() {
    		int curByte = 0;
    		try {
    			curByte = in.read();
    		} catch (IOException e) {
    			status = STATUS_FORMAT_ERROR;
    		}
    		return curByte;
    	}

    	/**
    	 * Reads next variable length block from input.
    	 *
    	 * @return number of bytes stored in "buffer"
    	 */
    	protected int readBlock() {
    		blockSize = read();
    		int n = 0;
    		if (blockSize > 0) {
    			try {
    				int count = 0;
    				while (n < blockSize) {
    					count = in.read(block, n, blockSize - n);
    					if (count == -1)
    						break;
    					n += count;
    				}
    			} catch (IOException e) {
    			}

    			if (n < blockSize) {
    				status = STATUS_FORMAT_ERROR;
    			}
    		}
    		return n;
    	}

    	/**
    	 * Reads color table as 256 RGB integer values
    	 *
    	 * @param ncolors int number of colors to read
    	 * @return int array containing 256 colors (packed ARGB with full alpha)
    	 */
    	protected int[] readColorTable(int ncolors) {
     		int nbytes = 3 * ncolors;
    		int[] tab = null;
    		byte[] c = new byte[nbytes];
    		int n = 0;
    // Read color table with this loop. J2ME's DataInputStream read() method
    // throws an exception if you try to read more than 255 bytes

            try {
                for (n = 0; n < nbytes; ++n)
                {
                c[n] = in.readByte();
                }
            } catch (IOException oe) {
                    ;
            }
    		if (n < nbytes) {
    			status = STATUS_FORMAT_ERROR;
    		} else {
    			tab = new int[256]; // max size to avoid bounds checks
    			int i = 0;
    			int j = 0;
    			while (i < ncolors) {
    				int r = ((int) c[j++]) & 0xff;
    				int g = ((int) c[j++]) & 0xff;
    				int b = ((int) c[j++]) & 0xff;
    				tab[i++] = 0xff000000 | (r << 16) | (g << 8) | b;
    			}
    		}
    		return tab;
    	}

    	/**
    	 * Main file parser.  Reads GIF content blocks.
    	 */
    	protected void readContents() {
    		// read GIF file content blocks
    		boolean done = false;
    		while (!(done || err())) {
    			int code = read();
    			switch (code) {

    				case 0x2C : // image separator
    					readImage();
    					break;

    				case 0x21 : // extension
    					code = read();
    					switch (code) {
    						case 0xf9 : // graphics control extension
    							readGraphicControlExt();
    							break;

    						case 0xff : // application extension
    							readBlock();
    							String app = "";
    							for (int i = 0; i < 11; i++) {
    								app += (char) block[i];
    							}
    							if (app.equals("NETSCAPE2.0")) {
    								readNetscapeExt();
    							}
    							else
    								skip(); // don't care
    							break;

    						default : // uninteresting extension
    							skip();
    					}
    					break;

    				case 0x3b : // terminator
    					done = true;
    					break;

    				case 0x00 : // bad byte, but keep going and see what happens
    					break;

    				default :
    					status = STATUS_FORMAT_ERROR;
    			}
    		}
    	}

    	/**
    	 * Reads Graphics Control Extension values
    	 */
    	protected void readGraphicControlExt() {
    		read(); // block size
    		int packed = read(); // packed fields
    		dispose = (packed & 0x1c) >> 2; // disposal method
    		if (dispose == 0) {
    			dispose = 1; // elect to keep old image if discretionary
    		}
    		transparency = (packed & 1) != 0;
    		delay = readShort() * 10; // delay in milliseconds
    		transIndex = read(); // transparent color index
    		read(); // block terminator
    	}

    	/**
    	 * Reads GIF file header information.
    	 */
    	protected void readHeader() {
    		String id = "";
    		for (int i = 0; i < 6; i++) {
    			id += (char) read();
    		}
    		if (!id.startsWith("GIF")) {
    			status = STATUS_FORMAT_ERROR;
    			return;
    		}

    		readLSD();
    		if (gctFlag && !err()) {
    			gct = readColorTable(gctSize);
    			bgColor = gct[bgIndex];
    		}
    	}

    	/**
    	 * Reads next frame image
    	 */
    	protected void readImage() {
    		ix = readShort(); // (sub)image position & size
    		iy = readShort();
    		iw = readShort();
    		ih = readShort();

    		int packed = read();
    		lctFlag = (packed & 0x80) != 0; // 1 - local color table flag
    		interlace = (packed & 0x40) != 0; // 2 - interlace flag
    		// 3 - sort flag
    		// 4-5 - reserved
    		lctSize = 2 << (packed & 7); // 6-8 - local color table size

    		if (lctFlag) {
    			lct = readColorTable(lctSize); // read table
    			act = lct; // make local table active
    		} else {
    			act = gct; // make global table active
    			if (bgIndex == transIndex)
    				bgColor = 0;
    		}
    		int save = 0;
    		if (transparency) {
    			save = act[transIndex];
    			act[transIndex] = 0; // set transparent color if specified
    		}

    		if (act == null) {
    			status = STATUS_FORMAT_ERROR; // no color table defined
    		}

    		if (err()) return;

    		decodeImageData(); // decode pixel data
    		skip();

    		if (err()) return;

    		frameCount++;

    		// create new image to receive frame data
    		imageData =
                javax.microedition.lcdui.Image.createImage(width, height);

    		setPixels(); // transfer pixel data to image

    		frames.addElement(new GifFrame(imageData, delay)); // add image to frame list

    		if (transparency) {
    			act[transIndex] = save;
    		}
    		resetFrame();

    	}

    	/**
    	 * Reads Logical Screen Descriptor
    	 */
    	protected void readLSD() {

    		// logical screen size
    		width = readShort();
    		height = readShort();

    		// packed fields
    		int packed = read();
    		gctFlag = (packed & 0x80) != 0; // 1   : global color table flag
    		// 2-4 : color resolution
    		// 5   : gct sort flag
    		gctSize = 2 << (packed & 0x07); // 6-8 : gct size

    		bgIndex = read(); // background color index
    		pixelAspect = read(); // pixel aspect ratio
    	}

    	/**
    	 * Reads Netscape extenstion to obtain iteration count
    	 */
    	protected void readNetscapeExt() {
    		do {
    			readBlock();
    			if (block[0] == 1) {
    				// loop count sub-block
    				int b1 = ((int) block[1]) & 0xff;
    				int b2 = ((int) block[2]) & 0xff;
    				loopCount = (b2 << 8) | b1;
    			}
    		} while ((blockSize > 0) && !err());
    	}

    	/**
    	 * Reads next 16-bit value, LSB first
    	 */
    	protected int readShort() {
    		// read 16-bit value, LSB first
    		return read() | (read() << 8);
    	}

    	/**
    	 * Resets frame state for reading next image.
    	 */
    	protected void resetFrame() {
    		lastDispose = dispose;
    		lx = ix;  ly = iy;  lw = iw;  lh = ih;
    		lastImage = imageData;
    		lastBgColor = bgColor;
    		lct = null;
    	}

    	/**
    	 * Skips variable length blocks up to and including
    	 * next zero length block.
    	 */
    	protected void skip() {
    		do {
    			readBlock();
    		} while ((blockSize > 0) && !err());
    	}
    }

}