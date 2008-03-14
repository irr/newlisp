//
//  LabelWidget.java
//  guiserver
//
//  Created by Lutz Mueller on 5/14/07.
//
//
//    Copyright (C) 2007 Lutz Mueller
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
//


import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class LabelWidget extends gsObject {

JLabel label;

@SuppressWarnings("unchecked") 
public LabelWidget(StringTokenizer params)
	{
	label = new JLabel();
	jcomponent = label;
	component = label;
	container = label;
	
	id = params.nextToken();
	String align = "center";
	if(params.hasMoreTokens())
		label.setText(Base64Coder.decodeString(params.nextToken()));
	
	if(params.hasMoreTokens())
		align = params.nextToken();
		
	if(align.equals("left")) label.setHorizontalAlignment(JLabel.LEFT);
	else if(align.equals("center")) label.setHorizontalAlignment(JLabel.CENTER);
	else if(align.equals("right")) 	label.setHorizontalAlignment(JLabel.RIGHT);
	else if(align.equals("leading")) label.setHorizontalAlignment(JLabel.LEADING);
	else if(align.equals("trailing")) label.setHorizontalAlignment(JLabel.TRAILING);
	else if(align.equals("bottom")) label.setVerticalAlignment(JLabel.BOTTOM);
	else if(align.equals("top")) label.setVerticalAlignment(JLabel.TOP);
		
	if(params.hasMoreTokens())
		{
		int width = Integer.parseInt(params.nextToken());
		int height = Integer.parseInt(params.nextToken());
		jcomponent.setPreferredSize(new Dimension(width, height));
		}
		
	gsObject.widgets.put(id, this);
	
	}


public void setText(StringTokenizer tokens)
	{
	String text = Base64Coder.decodeString(tokens.nextToken());
	label.setText(text);
	}
	
public void getText(StringTokenizer params)
	{
	String action = params.nextToken();
	String text = label.getText();
	if(text.length() == 0)
		guiserver.out.println("(" + action + " \"" + id + "\")");
	else
		guiserver.out.println("(" + action + " \"" + id + "\" [text]" + Base64Coder.encodeString(text) + "[/text])");
	guiserver.out.flush();
	}
	
public void appendText(StringTokenizer tokens)
	{
	String text = Base64Coder.decodeString(tokens.nextToken());
	String oldtext = label.getText();
	label.setText(oldtext + text);
	}
	
public void clearText(StringTokenizer tokens)
	{
	label.setText("");
	}

public void setIcon(StringTokenizer tokens)
	{
	String path = Base64Coder.decodeString(tokens.nextToken());
	label.setIcon(guiserver.getIconFromPath(path, this.getClass()));
	}

}
 
 
// eof //
