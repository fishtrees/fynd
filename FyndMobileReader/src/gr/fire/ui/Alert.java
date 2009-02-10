/*
 * Fire (Flexible Interface Rendering Engine) is a set of graphics widgets for creating GUIs for j2me applications. 
 * Copyright (C) 2006-2008 Bluevibe (www.bluevibe.net)
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */
package gr.fire.ui;


import gr.fire.browser.util.Command;
import gr.fire.core.BoxLayout;
import gr.fire.core.CommandListener;
import gr.fire.core.Component;
import gr.fire.core.Container;
import gr.fire.core.FireScreen;
import gr.fire.core.GridLayout;
import gr.fire.core.Panel;
import gr.fire.core.Theme;
import gr.fire.util.FireConnector;
import gr.fire.util.Lang;
import gr.fire.util.Log;

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

/**
 * The Alert is a utility class that displays an alert box (or popup message).
 * It is basically a Panel with some extra functionallity to make it easy to use as an Alert windo.
 *   
 * @author padeler
 *
 */
public class Alert extends Container implements CommandListener
{
	/**
	 * Alert message with an OK button to close.
	 */
	public static final byte TYPE_INFO=0x01;
	
	public static final byte TYPE_WARNING=0x02;
	public static final byte TYPE_ERROR=0x03;
	/**
	 * Question with two buttons, Yes and No.
	 */
	public static final byte TYPE_YESNO=0x04;
	/**
	 * Question with three buttons, Yes and No and Cancel.
	 */	
	public static final byte TYPE_YESNOCANCEL=0x05;
	
	
	
	public static final byte USER_SELECTED_OK=0x01;
	public static final byte USER_SELECTED_YES=0x02;
	public static final byte USER_SELECTED_NO=0x03;
	public static final byte USER_SELECTED_CANCEL=0x04;
	
	
	private Command yes,no,ok,cancel;
	private byte type=0x00,userSelection=0x00;
	
	public Alert(String txt, byte type)
	{
		super(new BoxLayout(BoxLayout.Y_AXIS));
		
		if(txt==null) throw new NullPointerException("Alert message cannot be null.");
		
		Container buttonCnt=null;
		
		this.type=type;
		FireScreen screen = FireScreen.getScreen();
		
		int screenWidth = screen.getWidth();
		int screenHeight = screen.getHeight();
		
		int height=(screenHeight/2),width=((screenWidth*3)/4);
		
		Container messageCnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
		messageCnt.setBorder(true);
		Image icon=null;
		Theme theme = FireScreen.getTheme();
		String iconPath=null;
		try{
			InputComponent button;
			switch(type)
			{
			case TYPE_WARNING:
				iconPath = theme.getStringProperty("alert.warning.icon");
				buttonCnt = new Container(new GridLayout(1,1));
				button= new InputComponent(InputComponent.BUTTON);
				ok = new Command(Lang.get("Ok"),Command.OK,1);
				button.setValue(ok.getLabel());
				button.setMaxWidth(width);
				button.setCommand(ok);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				buttonCnt.setPrefSize(width,button.getMinSize()[1]);
				break;
			case TYPE_ERROR:
				iconPath = theme.getStringProperty("alert.error.icon");
				buttonCnt = new Container(new GridLayout(1,1));
				button= new InputComponent(InputComponent.BUTTON);
				ok = new Command(Lang.get("Ok"),Command.OK,1);
				button.setValue(ok.getLabel());
				button.setMaxWidth(width);
				button.setCommand(ok);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				buttonCnt.setPrefSize(width,button.getMinSize()[1]);
				break;
			case TYPE_YESNO:
				iconPath = theme.getStringProperty("alert.yesno.icon");
				buttonCnt = new Container(new GridLayout(1,2));
				button= new InputComponent(InputComponent.BUTTON); // yes button
				yes = new Command(Lang.get("Yes"),Command.OK,1);
				button.setValue(yes.getLabel());
				button.setMaxWidth(width/2);
				button.setCommand(yes);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				button= new InputComponent(InputComponent.BUTTON); // no button
				no= new Command(Lang.get("No"),Command.OK,1);
				button.setValue(no.getLabel());
				button.setMaxWidth(width/2);
				button.setCommand(no);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				buttonCnt.setPrefSize(width,button.getMinSize()[1]);
				break;
			case TYPE_YESNOCANCEL:
				iconPath = theme.getStringProperty("alert.yesnocancel.icon");
				buttonCnt = new Container(new GridLayout(1,3));
				button= new InputComponent(InputComponent.BUTTON); // yes button
				yes = new Command(Lang.get("Yes"),Command.OK,1);
				button.setValue(yes.getLabel());
				button.setMaxWidth(width/2);
				button.setCommand(yes);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				button= new InputComponent(InputComponent.BUTTON); // no button
				no= new Command(Lang.get("No"),Command.OK,1);
				button.setValue(no.getLabel());
				button.setMaxWidth(width/2);
				button.setCommand(no);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				button= new InputComponent(InputComponent.BUTTON); // cancel button
				cancel = new Command(Lang.get("Cancel"),Command.OK,1);
				button.setValue(cancel.getLabel());
				button.setMaxWidth(width/2);
				button.setCommand(cancel);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				buttonCnt.setPrefSize(width,button.getMinSize()[1]);
				break;			
			default: // default is Information alert.
				iconPath = theme.getStringProperty("alert.info.icon");
				buttonCnt = new Container(new GridLayout(1,1));
				button= new InputComponent(InputComponent.BUTTON);
				ok = new Command(Lang.get("Ok"),Command.OK,1);
				button.setValue(ok.getLabel());
				button.setMaxWidth(width);
				button.setCommand(ok);
				button.setLayout(FireScreen.CENTER|FireScreen.VCENTER);
				button.setCommandListener(this);
				buttonCnt.add(button);
				buttonCnt.setPrefSize(width,button.getFont().getHeight()*2);
				break;
			}
			if(iconPath!=null)
				icon = Image.createImage(new FireConnector().openInputStream(iconPath));
		}catch(Exception e){
			Log.logWarn("Failed to load Alert icon form: "+iconPath,e);
		}
		
		int w = width;
		
		if(icon!=null)
		{
			ImageComponent iconCmp = new ImageComponent(icon,"");
			iconCmp.setLayout(FireScreen.CENTER|FireScreen.TOP);
			iconCmp.validate();
			int th = icon.getHeight();
			if(th>height)
				height=th;
			w -=icon.getWidth();
			messageCnt.add(iconCmp);
		}

		TextComponent txtCmp = new TextComponent(txt,w);
		txtCmp.setFont(theme.getFontProperty("alert.font"));
		txtCmp.setLayout(FireScreen.LEFT|FireScreen.VCENTER);
		txtCmp.validate();
		int th = txtCmp.getContentHeight();
		if(th>height) height=th;
		messageCnt.add(txtCmp);
		messageCnt.setPrefSize(width,height);
		
		int maxHeight = ((3*FireScreen.getScreen().getHeight())/4);
		if(height>maxHeight) height=maxHeight;
		Panel messagePanel = new Panel(messageCnt,Panel.VERTICAL_SCROLLBAR,false);
		messagePanel.setShowBackground(true);
		messagePanel.setPrefSize(width,height);

		add(messagePanel);
		add(buttonCnt);
		
		setX(screenWidth/2-width/2);
		setY(screenHeight);
		
		FlyAnimation anim = new FlyAnimation(getX(),getY(),getX(),screenHeight/2-(height+buttonCnt.getPrefSize()[1])/2);
		setAnimation(anim);
	}

	public byte getType()
	{
		return type;
	}

	public void commandAction(javax.microedition.lcdui.Command cmd, Component c)
	{
		if(cmd==ok)
		{
			userSelection=USER_SELECTED_OK;
		}
		else if(cmd==yes)
		{
			userSelection=USER_SELECTED_YES;
		}
		else if(cmd==no)
		{
			userSelection=USER_SELECTED_NO;
		}
		else if(cmd==cancel)
		{
			userSelection=USER_SELECTED_CANCEL;
		}
		
		FireScreen.getScreen().removeComponent(this);
		if(command!=null && commandListener!=null) commandListener.commandAction(command,this); 
	}

	public void commandAction(javax.microedition.lcdui.Command arg0, Displayable arg1)
	{
		// TODO Auto-generated method stub
		
	}

	public byte getUserSelection()
	{
		return userSelection;
	}
}