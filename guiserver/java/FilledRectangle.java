//
//  FilledRectangle.java
//  guiserver
//
//  Created by Lutz Mueller on 6/24/07.
//
//
//    Copyright (C) 2015 Lutz Mueller
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
import java.awt.color.*;
import java.awt.geom.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class FilledRectangle extends Shape {

int X;
int Y;
int width;
int height;

public FilledRectangle(StringTokenizer tokens)
	{
	float R, G, B;
	float alpha;
	
	tag = tokens.nextToken();
	X = Integer.parseInt(tokens.nextToken());
	Y = Integer.parseInt(tokens.nextToken());
	width = Integer.parseInt(tokens.nextToken());
	height = Integer.parseInt(tokens.nextToken());
	if(tokens.hasMoreTokens())
		{
		R = Float.parseFloat(tokens.nextToken());
		G = Float.parseFloat(tokens.nextToken());
		B = Float.parseFloat(tokens.nextToken());
		if(tokens.hasMoreTokens())
			alpha = Float.parseFloat(tokens.nextToken());
		else 
			alpha = 1;
		paintColor = new Color(R, G, B, alpha);
		}
	else
		paintColor = CanvasWidget.currentCanvas.currentPaint;
	
	stroke = CanvasWidget.currentCanvas.currentStroke;
	
	CanvasWidget.currentCanvas.drawobjects.add(this);
	}
	
public void drawShape(Graphics2D g2)
	{
	g2.setStroke(stroke);
	g2.setPaint(paintColor);
	//g2.setComposite(currentComposite);
	g2.fillRect(X, Y, width, height);
	}

}
 
 
// eof //
