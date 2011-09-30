/*
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, 
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.report.birt.chart;

/**
 * 
 * @author daniel
 *
 */
public class LineChartXml {
	
	/**
	 * Gets the chart xml which should be after the Block node.
	 * 
	 * @param numericColName the name of the column with numeric values.
	 * @param textColName the name of the column which serves as label.
	 * @param type the type of char. eg Pie, Bar, Line, etc
	 * @param xAxisTitle the x axis title for the chart.
	 * @param yAxisTitle the y axis title for the chart.
	 * @return the xml.
	 */
	public static String getXml(String numericColName, String textColName, String type,String xAxisTitle, String yAxisTitle){
		return "<Dimension>Two_Dimensional</Dimension> "+
		"<Units>Points</Units> "+
		"<SeriesThickness>10.0</SeriesThickness> "+
		"<GridColumnCount>0</GridColumnCount> "+
		"<SampleData> "+
		"  <BaseSampleData> "+
		"    <DataSetRepresentation>A, B, C</DataSetRepresentation> "+
		"  </BaseSampleData> "+
		"  <OrthogonalSampleData> "+
		"    <DataSetRepresentation>5,4,12</DataSetRepresentation> "+
		"    <SeriesDefinitionIndex>0</SeriesDefinitionIndex> "+
		"  </OrthogonalSampleData> "+
		"</SampleData> "+
		"<Interactivity> "+
		"  <Enable>true</Enable> "+
		"  <LegendBehavior>None</LegendBehavior> "+
		"</Interactivity> "+
		"<EmptyMessage> "+
		"  <Caption> "+
		"    <Value>This chart contains no data.</Value> "+
		"    <Font> "+
		"      <Alignment> "+
		"        <horizontalAlignment>Center</horizontalAlignment> "+
		"        <verticalAlignment>Center</verticalAlignment> "+
		"      </Alignment> "+
		"    </Font> "+
		"  </Caption> "+
		"  <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"    <Transparency>64</Transparency> "+
		"    <Red>127</Red> "+
		"    <Green>127</Green> "+
		"    <Blue>127</Blue> "+
		"  </Background> "+
		"  <Outline> "+
		"    <Color> "+
		"      <Transparency>128</Transparency> "+
		"      <Red>127</Red> "+
		"      <Green>127</Green> "+
		"      <Blue>127</Blue> "+
		"    </Color> "+
		"    <Visible>true</Visible> "+
		"  </Outline> "+
		"  <Insets> "+
		"    <Top>10.0</Top> "+
		"    <Left>10.0</Left> "+
		"    <Bottom>10.0</Bottom> "+
		"    <Right>10.0</Right> "+
		"  </Insets> "+
		"</EmptyMessage> "+
		"<Axes> "+
		"  <Type>Text</Type> "+
		"  <Title> "+
		"    <Caption> "+
		"      <Value>" + xAxisTitle + "</Value> "+
		"      <Font> "+
		"        <Size>14.0</Size> "+
		"        <Bold>true</Bold> "+
		"        <Alignment> "+
		"          <horizontalAlignment>Center</horizontalAlignment> "+
		"          <verticalAlignment>Center</verticalAlignment> "+
		"        </Alignment> "+
		"      </Font> "+
		"    </Caption> "+
		"    <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"      <Transparency>0</Transparency> "+
		"      <Red>255</Red> "+
		"      <Green>255</Green> "+
		"      <Blue>255</Blue> "+
		"    </Background> "+
		"    <Outline> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>0</Blue> "+
		"      </Color> "+
		"    </Outline> "+
		"    <Insets> "+
		"      <Top>0.0</Top> "+
		"      <Left>2.0</Left> "+
		"      <Bottom>0.0</Bottom> "+
		"      <Right>3.0</Right> "+
		"    </Insets> "+
		"    <Visible>true</Visible> "+
		"  </Title> "+
		"  <TitlePosition>Below</TitlePosition> "+
		"  <AssociatedAxes> "+
		"    <Type>Linear</Type> "+
		"    <Title> "+
		"      <Caption> "+
		"        <Value>" + yAxisTitle + "</Value> "+
		"        <Font> "+
		"          <Size>14.0</Size> "+
		"          <Bold>true</Bold> "+
		"          <Alignment> "+
		"            <horizontalAlignment>Center</horizontalAlignment> "+
		"            <verticalAlignment>Center</verticalAlignment> "+
		"          </Alignment> "+
		"          <Rotation>90.0</Rotation> "+
		"        </Font> "+
		"      </Caption> "+
		"      <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>0</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>255</Blue> "+
		"      </Background> "+
		"      <Outline> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>0</Blue> "+
		"        </Color> "+
		"      </Outline> "+
		"      <Insets> "+
		"        <Top>0.0</Top> "+
		"        <Left>2.0</Left> "+
		"        <Bottom>0.0</Bottom> "+
		"        <Right>3.0</Right> "+
		"      </Insets> "+
		"      <Visible>true</Visible> "+
		"    </Title> "+
		"    <TitlePosition>Left</TitlePosition> "+
		"    <SeriesDefinitions> "+
		"      <Query> "+
		"        <Definition></Definition> "+
		"      </Query> "+
		"      <SeriesPalette> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>80</Red> "+
		"          <Green>166</Green> "+
		"          <Blue>218</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>242</Red> "+
		"          <Green>88</Green> "+
		"          <Blue>106</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>232</Red> "+
		"          <Green>172</Green> "+
		"          <Blue>57</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>255</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>64</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>192</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>170</Red> "+
		"          <Green>85</Green> "+
		"           <Blue>85</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>0</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>192</Red> "+
		"          <Green>192</Green> "+
		"          <Blue>192</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>255</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>192</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>7</Red> "+
		"          <Green>146</Green> "+
		"          <Blue>94</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>255</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>192</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>255</Green> "+
		"          <Blue>255</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>192</Blue> "+
		"        </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>192</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>255</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>64</Green> "+
		"          <Blue>64</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"         <Red>255</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>64</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>80</Red> "+
		"          <Green>240</Green> "+
		"          <Blue>120</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>64</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>64</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"         <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>64</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>128</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>128</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>255</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>64</Green> "+
		"          <Blue>0</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>0</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>255</Green> "+
		"          <Blue>255</Blue> "+
		"        </Entries> "+
		"       <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>128</Green> "+
		"          <Blue>0</Blue> "+
		"        </Entries> "+
		"      </SeriesPalette> " + getSecond(type,numericColName,textColName);
	}
	
	private static String getSecond(String type, String numericColName, String textColName){
		return "      <Series xsi:type=\"type:" + type + "Series\"> "+
		"        <Visible>true</Visible> "+
		"        <Label> "+
		"          <Caption> "+
		"            <Value></Value> "+
		"            <Font> "+
		"              <Alignment/> "+
		"            </Font> "+
		"          </Caption> "+
		"          <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"            <Transparency>0</Transparency> "+
		"            <Red>255</Red> "+
		"            <Green>255</Green> "+
		"            <Blue>255</Blue> "+
		"          </Background> "+
		"          <Outline> "+
		"            <Style>Solid</Style> "+
		"            <Thickness>1</Thickness> "+
		"            <Color> "+
		"              <Transparency>255</Transparency> "+
		"              <Red>0</Red> "+
		"              <Green>0</Green> "+
		"              <Blue>0</Blue> "+
		"            </Color> "+
		"            <Visible>false</Visible> "+
		"          </Outline> "+
		"          <Insets> "+
		"            <Top>0.0</Top> "+
		"            <Left>2.0</Left> "+
		"            <Bottom>0.0</Bottom> "+
		"            <Right>3.0</Right> "+
		"          </Insets> "+
		"          <Visible>false</Visible> "+
		"        </Label> "+
		"        <DataDefinition> "+
		"          <Definition>row[&quot;" + numericColName + "&quot;]</Definition> "+
		"          <Grouping> "+
		"            <GroupType>Text</GroupType> "+
		"            <AggregateExpression>Sum</AggregateExpression> "+
		"          </Grouping> "+
		"        </DataDefinition> "+
		"        <SeriesIdentifier></SeriesIdentifier> "+
		"        <DataPoint> "+
		"          <Components> "+
		"            <Type>Orthogonal_Value</Type> "+
		"          </Components> "+
		"          <Separator>, </Separator> "+
		"        </DataPoint> "+
		"        <LabelPosition>Above</LabelPosition> "+
		"        <Stacked>false</Stacked> "+
		"      <Markers> "+
		"        <Type>Box</Type> "+
		"        <Size>4</Size> "+
		"        <Visible>true</Visible> "+
		"        <Outline> "+
		"          <Visible>true</Visible> "+
		"        </Outline> "+
		"      </Markers> "+
		"      <LineAttributes> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>0</Blue> "+
		"        </Color> "+
		"        <Visible>true</Visible> "+
		"      </LineAttributes> "+
		"      <PaletteLineColor>true</PaletteLineColor> "+
		"      </Series> "+
		"      <Grouping> "+
		"        <GroupType>Text</GroupType> "+
		"        <AggregateExpression>Sum</AggregateExpression> "+
		"      </Grouping> "+
		"    </SeriesDefinitions> "+
		"    <Orientation>Vertical</Orientation> "+
		"    <LineAttributes> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Visible>true</Visible> "+
		"    </LineAttributes> "+
		"    <Label> "+
		"      <Caption> "+
		"        <Value></Value> "+
		"        <Font> "+
		"          <Alignment/> "+
		"        </Font> "+
		"      </Caption> "+
		"      <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>0</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>255</Blue> "+
		"      </Background> "+
		"      <Outline> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>0</Red> "+
		"          <Green>0</Green> "+
		"          <Blue>0</Blue> "+
		"        </Color> "+
		"      </Outline> "+
		"      <Insets> "+
		"        <Top>0.0</Top> "+
		"        <Left>2.0</Left> "+
		"        <Bottom>0.0</Bottom> "+
		"        <Right>3.0</Right> "+
		"      </Insets> "+
		"      <Visible>true</Visible> "+
		"    </Label> "+
		"    <LabelPosition>Left</LabelPosition> "+
		"    <MajorGrid> "+
		"      <LineAttributes> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>196</Red> "+
		"          <Green>196</Green> "+
		"          <Blue>196</Blue> "+
		"        </Color> "+
		"        <Visible>false</Visible> "+
		"      </LineAttributes> "+
		"      <TickStyle>Across</TickStyle> "+
		"      <TickAttributes> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>196</Red> "+
		"          <Green>196</Green> "+
		"          <Blue>196</Blue> "+
		"        </Color> "+
		"        <Visible>true</Visible> "+
		"      </TickAttributes> "+
		"    </MajorGrid> "+
		"    <MinorGrid> "+
		"      <LineAttributes> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>225</Red> "+
		"          <Green>225</Green> "+
		"          <Blue>225</Blue> "+
		"        </Color> "+
		"        <Visible>false</Visible> "+
		"      </LineAttributes> "+
		"      <TickStyle>Across</TickStyle> "+
		"      <TickAttributes> "+
		"        <Style>Solid</Style> "+
		"        <Thickness>1</Thickness> "+
		"        <Color> "+
		"          <Transparency>255</Transparency> "+
		"          <Red>225</Red> "+
		"          <Green>225</Green> "+
		"          <Blue>225</Blue> "+
		"        </Color> "+
		"        <Visible>false</Visible> "+
		"      </TickAttributes> "+
		"    </MinorGrid> "+
		"    <Scale> "+
		"      <MinorGridsPerUnit>5</MinorGridsPerUnit> "+
		"    </Scale> "+
		"    <Origin> "+
		"      <Type>Min</Type> "+
		"      <Value xsi:type=\"data:NumberDataElement\"> "+
		"        <Value>0.0</Value> "+
		"      </Value> "+
		"    </Origin> "+
		"    <PrimaryAxis>true</PrimaryAxis> "+
		"    <Percent>false</Percent> "+
		"  </AssociatedAxes> "+
		"  <SeriesDefinitions> "+
		"    <Query> "+
		"      <Definition></Definition> "+
		"    </Query> "+
		"    <SeriesPalette> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>80</Red> "+
		"        <Green>166</Green> "+
		"        <Blue>218</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>242</Red> "+
		"        <Green>88</Green> "+
		"        <Blue>106</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>232</Red> "+
		"        <Green>172</Green> "+
		"        <Blue>57</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>64</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>192</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>170</Red> "+
		"        <Green>85</Green> "+
		"        <Blue>85</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"       <Green>128</Green> "+
		"        <Blue>0</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>192</Red> "+
		"        <Green>192</Green> "+
		"        <Blue>192</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>192</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>7</Red> "+
		"        <Green>146</Green> "+
		"        <Blue>94</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>255</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>192</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>255</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>192</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>192</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>255</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>64</Green> "+
		"        <Blue>64</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"       <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>64</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>80</Red> "+
		"        <Green>240</Green> "+
		"        <Blue>120</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>64</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>64</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>128</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>64</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>128</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>128</Blue> "+
		"     </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>255</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>64</Green> "+
		"        <Blue>0</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>0</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>255</Green> "+
		"        <Blue>255</Blue> "+
		"      </Entries> "+
		"        <Entries xsi:type=\"attribute:ColorDefinition\"> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>255</Red> "+
		"        <Green>128</Green> "+
		"        <Blue>0</Blue> "+
		"      </Entries> "+
		"    </SeriesPalette> "+
		"    <Series> "+
		"      <Visible>true</Visible> "+
		"      <Label> "+
		"        <Caption> "+
		"          <Value></Value> "+
		"          <Font> "+
		"            <Alignment/> "+
		"          </Font> "+
		"        </Caption> "+
		"        <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"          <Transparency>0</Transparency> "+
		"          <Red>255</Red> "+
		"          <Green>255</Green> "+
		"          <Blue>255</Blue> "+
		"        </Background> "+
		"        <Outline> "+
		"          <Style>Solid</Style> "+
		"          <Thickness>1</Thickness> "+
		"          <Color> "+
		"            <Transparency>255</Transparency> "+
		"            <Red>0</Red> "+
		"            <Green>0</Green> "+
		"            <Blue>0</Blue> "+
		"          </Color> "+
		"          <Visible>false</Visible> "+
		"        </Outline> "+
		"        <Insets> "+
		"          <Top>0.0</Top> "+
		"          <Left>2.0</Left> "+
		"          <Bottom>0.0</Bottom> "+
		"          <Right>3.0</Right> "+
		"        </Insets> "+
		"        <Visible>false</Visible> "+
		"      </Label> "+
		"      <DataDefinition> "+
		"        <Definition>row[&quot;" + textColName + "&quot;]</Definition> "+
		"      </DataDefinition> "+
		"      <SeriesIdentifier></SeriesIdentifier> "+
		"      <DataPoint> "+
		"        <Components> "+
		"          <Type>Orthogonal_Value</Type> "+
		"        </Components> "+
		"        <Separator>, </Separator> "+
		"      </DataPoint> "+
		"      <LabelPosition>Outside</LabelPosition> "+
		"      <Stacked>false</Stacked> "+
		"    </Series> "+
		"    <Grouping> "+
		"      <Enabled>true</Enabled> "+
		"      <GroupType>Text</GroupType> "+
		"      <AggregateExpression>Sum</AggregateExpression> "+
		"    </Grouping> "+
		"  </SeriesDefinitions> "+
		"  <Orientation>Horizontal</Orientation> "+
		"  <LineAttributes> "+
		"    <Style>Solid</Style> "+
		"    <Thickness>1</Thickness> "+
		"    <Visible>true</Visible> "+
		"  </LineAttributes> "+
		"  <Label> "+
		"    <Caption> "+
		"      <Value></Value> "+
		"      <Font> "+
		"        <Alignment/> "+
		"      </Font> "+
		"    </Caption> "+
		"    <Background xsi:type=\"attribute:ColorDefinition\"> "+
		"      <Transparency>0</Transparency> "+
		"      <Red>255</Red> "+
		"      <Green>255</Green> "+
		"      <Blue>255</Blue> "+
		"    </Background> "+
		"    <Outline> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>0</Red> "+
		"        <Green>0</Green> "+
		"        <Blue>0</Blue> "+
		"      </Color> "+
		"    </Outline> "+
		"    <Insets> "+
		"      <Top>0.0</Top> "+
		"      <Left>2.0</Left> "+
		"      <Bottom>0.0</Bottom> "+
		"      <Right>3.0</Right> "+
		"    </Insets> "+
		"    <Visible>true</Visible> "+
		"  </Label> "+
		"  <LabelPosition>Below</LabelPosition> "+
		"  <MajorGrid> "+
		"    <LineAttributes> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>196</Red> "+
		"        <Green>196</Green> "+
		"        <Blue>196</Blue> "+
		"      </Color> "+
		"      <Visible>false</Visible> "+
		"    </LineAttributes> "+
		"    <TickStyle>Across</TickStyle> "+
		"    <TickAttributes> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>196</Red> "+
		"        <Green>196</Green> "+
		"        <Blue>196</Blue> "+
		"      </Color> "+
		"      <Visible>true</Visible> "+
		"    </TickAttributes> "+
		"  </MajorGrid> "+
		"  <MinorGrid> "+
		"    <LineAttributes> "+
		"      <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>225</Red> "+
		"        <Green>225</Green> "+
		"        <Blue>225</Blue> "+
		"      </Color> "+
		"      <Visible>false</Visible> "+
		"    </LineAttributes> "+
		"    <TickStyle>Across</TickStyle> "+
		"    <TickAttributes> "+
		"     <Style>Solid</Style> "+
		"      <Thickness>1</Thickness> "+
		"      <Color> "+
		"        <Transparency>255</Transparency> "+
		"        <Red>225</Red> "+
		"        <Green>225</Green> "+
		"        <Blue>225</Blue> "+
		"      </Color> "+
		"      <Visible>false</Visible> "+
		"    </TickAttributes> "+
		"  </MinorGrid> "+
		"  <Scale> "+
		"    <MinorGridsPerUnit>5</MinorGridsPerUnit> "+
		"  </Scale> "+
		"  <Origin> "+
		"    <Type>Min</Type> "+
		"    <Value xsi:type=\"data:NumberDataElement\"> "+
		"      <Value>0.0</Value> "+
		"    </Value> "+
		"  </Origin> "+
		"  <PrimaryAxis>true</PrimaryAxis> "+
		"  <CategoryAxis>true</CategoryAxis> "+
		"  <Percent>false</Percent> "+
		"</Axes> "+
		"<Orientation>Vertical</Orientation> "+
		"<Rotation/>";
	}
}
