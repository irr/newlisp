//
//  ComboBoxWidget.java
//  guiserver
//
//  Created by Lutz Mueller on 5/13/07.
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


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


@SuppressWarnings("unchecked") 
public class ComboBoxWidget extends gsObject implements ActionListener{

JComboBox combobox;

public ComboBoxWidget(StringTokenizer params)
	{
	combobox = new JComboBox();
	jcomponent = combobox;
	component = combobox;
	container = combobox;
	
	id = params.nextToken();
	action = params.nextToken();
		
	while(params.hasMoreTokens())
		combobox.addItem(Base64Coder.decodeString(params.nextToken()));

	gsObject.widgets.put(id, this);

	combobox.addActionListener(this);
	}
	
public void actionPerformed(ActionEvent e)
	{
	int index = combobox.getSelectedIndex();
	String idx = Integer.toString(index);
	String item = Base64Coder.encodeString(combobox.getSelectedItem().toString());
	guiserver.out.println("(" + action + " \"" + id + "\" " + idx + " \"" + item + "\")");
	guiserver.out.flush();
	}
	
public void addListItem(StringTokenizer tokens)
	{
	while(tokens.hasMoreTokens()) 
		combobox.addItem(Base64Coder.decodeString(tokens.nextToken()));
	}
	
public void removeListItem(StringTokenizer tokens)
	{
	int index = 0; 
	
	while(tokens.hasMoreTokens()) 
		{
		index = Integer.parseInt(tokens.nextToken());
		if(index > (combobox.getItemCount() - 1)) index = combobox.getItemCount() - 1;
		if(index < 0) index = 0;
		combobox.removeItemAt(index);
		}
	}

public void insertListItem(StringTokenizer tokens)
	{
	int index = 0; 
	String text;
	
	while(tokens.hasMoreTokens())
		{
		text = Base64Coder.decodeString(tokens.nextToken());
		index = Integer.parseInt(tokens.nextToken());
		if(index > (combobox.getItemCount() - 1)) index = combobox.getItemCount() - 1;
		if(index < 0) index = 0;
		combobox.insertItemAt(text, index);
		}
	}
	
public void selectListItem(StringTokenizer tokens)
	{
	String item = Base64Coder.decodeString(tokens.nextToken());
	combobox.setSelectedItem(item);
	}

public void clearList(StringTokenizer tokens)
	{
	combobox.removeAllItems();
	}
	
}
 
 
// eof //
