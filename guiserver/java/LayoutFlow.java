//
//  LayoutFlow.java
//  guiserver
//
//  Created by Lutz Mueller on 5/14/07.
//
//
//    Copyright (C) 2011 Lutz Mueller
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


import java.awt.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class LayoutFlow extends FlowLayout{

public LayoutFlow(StringTokenizer params)
	{
	super();
	
	String id = params.nextToken();
	
	gsObject gsobject = (gsObject)gsObject.widgets.get(id);
	
	Container target = gsobject.container;
	setAlignment(FlowLayout.LEFT);
	
	if(params.hasMoreTokens())
		{
		String alignment = params.nextToken();
		if(alignment.equals("left")) setAlignment(FlowLayout.LEFT);
		if(alignment.equals("center")) setAlignment(FlowLayout.CENTER);
		if(alignment.equals("right")) setAlignment(FlowLayout.RIGHT);
		}
	else setAlignment(FlowLayout.LEFT);

	if(params.hasMoreTokens())
		{
		setHgap(Integer.parseInt(params.nextToken()));
		setVgap(Integer.parseInt(params.nextToken()));
		}
	
	target.setLayout(this);
	}
	
}
 
 
// eof //
