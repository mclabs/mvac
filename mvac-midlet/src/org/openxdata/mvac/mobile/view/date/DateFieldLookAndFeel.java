/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view.date;

import com.sun.lwuit.Component;
import com.sun.lwuit.Font;
import com.sun.lwuit.Graphics;
import com.sun.lwuit.TextField;
import com.sun.lwuit.plaf.DefaultLookAndFeel;
import com.sun.lwuit.plaf.Style;

/**
 *
 * @author mluz and eloijr
 */

public class DateFieldLookAndFeel extends DefaultLookAndFeel {

  public void drawTextField(Graphics g, TextField df) {
    if (df instanceof DateField)
      drawDateField(g, (DateField) df);
    else
      super.drawTextField(g, df);
  }

  private void drawDateField(Graphics g, DateField df) {
    setFG(g, df);

    String displayText = df.getText();

    // DD = QW
    // MM = ER
    // YYYY = TYUI

    Style style = df.getStyle();
    int x = 0;
    int cursorCharPosition = df.getCursorPosition();
    Font f = df.getStyle().getFont();
    int cursorX = 0;
    int xPos = 0;
    if (cursorCharPosition > 0) {
      xPos = f.stringWidth(displayText.substring(0, cursorCharPosition));
      cursorX = df.getX() + style.getPadding(Component.LEFT) + xPos;
      if (df.getWidth() > (f.getHeight() * 2) && cursorX >= df.getWidth() - style.getPadding(Component.LEFT)) {
          while (x + xPos >= df.getWidth() - style.getPadding(Component.LEFT) * 2) {
              x--;
          }
      }
    }
    g.setColor(0xFF0000);

    int xString = df.getX() + x + style.getPadding(Component.LEFT);
    int yString = df.getY() + style.getPadding(Component.TOP);

    // first field
    String field1 = df.getField(1);
    String field2 = df.getField(2);
    String field3 = df.getField(3);
    String separator = "/";// df.getSeparator();

    // field 1
    if (df.isSelectMode() && df.getFieldSelected() == 1 && df.hasFocus() && df.isFocusPainted()) {
      setFG(g, df);
      g.fillRect(xString-1, yString, f.stringWidth(field1)+2, f.getHeight());
      //g.setColor(df.getStyle().getBgSelectionColor()); //mims Change
      g.setColor(df.getStyle().getBgColor());
    } else
      setFG(g, df);
    g.drawString(field1, xString, yString);

    // separator
    xString += f.stringWidth(field1);
    setFG(g, df);
    g.drawString(separator, xString, df.getY() + style.getPadding(Component.TOP));

    //field 2
    xString += f.stringWidth(separator);
    if (df.isSelectMode() && df.getFieldSelected() == 2 && df.hasFocus() && df.isFocusPainted()) {
      setFG(g, df);
      g.fillRect(xString-1, yString, f.stringWidth(field2)+2, f.getHeight());
      //g.setColor(df.getStyle().getBgSelectionColor()); //mims change
      g.setColor(df.getStyle().getBgColor());
    } else
      setFG(g, df);
    g.drawString(field2, xString, df.getY() + style.getPadding(Component.TOP));

    // separator
    xString += f.stringWidth(field2);
    setFG(g, df);
    g.drawString(separator, xString, df.getY() + style.getPadding(Component.TOP));

    // field 3
    xString += f.stringWidth(separator);
    if (df.isSelectMode() && df.getFieldSelected() == 3 && df.hasFocus() && df.isFocusPainted()) {
      setFG(g, df);
      g.fillRect(xString-1, yString, f.stringWidth(field3)+2, f.getHeight());
      //g.setColor(df.getStyle().getBgSelectionColor()); //mims change
      g.setColor(df.getStyle().getBgColor());
    } else
      setFG(g, df);
    g.drawString(field3, xString, df.getY() + style.getPadding(Component.TOP));

    //g.drawString(displayText, xString, df.getY() + style.getPadding(Component.TOP));

    // show always
    boolean showAlways = false; // For now, I don't want to show inputMode
    if (showAlways) { // (df.getInputModeOrder() != null && df.getInputModeOrder().length > 0) {
      String inputMode = df.getInputMode();
      int inputModeWidth = f.stringWidth(inputMode);
      if (df.handlesInput() && df.getWidth() / 2 > inputModeWidth) {
        int drawXPos = df.getX() + style.getPadding(Component.LEFT) -1;
        if (xPos < df.getWidth() / 2) {
          // draw on the right side
          drawXPos = drawXPos + df.getWidth() - inputModeWidth - style.getPadding(Component.RIGHT) - style.getPadding(Component.LEFT)+2;
        }
        //g.setColor(style.getFgSelectionColor()); //mims change
        g.setColor(style.getBgColor());
        // unfortunatelly g.fillroundrect does not suppport alpha
        //g.fillRoundRect(drawXPos, ta.getY() + style.getPadding(Component.TOP)-1, inputModeWidth, ta.getHeight()-4, 4, 4);
        // so a work around is required
        byte alphaLevel = (byte)140;
        g.fillRect(drawXPos, df.getY() + style.getPadding(Component.TOP)-1, inputModeWidth,
                df.getHeight()-4, alphaLevel);
        //g.setColor(0xFF0000);

        //g.setColor(style.getBgSelectionColor()); //mims change
        g.setColor(style.getBgColor());

        g.fillRect(drawXPos, df.getY() + style.getPadding(Component.TOP)-1, 1, 1, alphaLevel);
        g.fillRect(drawXPos + inputModeWidth -1, df.getY() + style.getPadding(Component.TOP)-1, 1, 1, alphaLevel);
        g.fillRect(drawXPos + inputModeWidth -1, df.getY() + style.getPadding(Component.TOP)-1 + df.getHeight()-4 -1, 1, 1, alphaLevel);
        g.fillRect(drawXPos, df.getY() + style.getPadding(Component.TOP)-1 + df.getHeight()-4 -1, 1, 1, alphaLevel);

        g.drawString(inputMode, drawXPos, df.getY() + style.getPadding(Component.TOP));
      }
    }
  }

}