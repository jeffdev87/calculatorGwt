/*
 * Jeferson William Teixeira
 * 2008-2016
 */

package com.poo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

enum OPERATION {ADD, SUB, DIV, MULTP};

public class Calc implements EntryPoint {
 	
  private VerticalPanel mainPanel = new VerticalPanel();   
  private HorizontalPanel PanelHorizontal = new HorizontalPanel();
  private TextBox TxtNum1 = new TextBox();
  private TextBox TxtNum2 = new TextBox();
  private TextBox TxtResult = new TextBox();
  private Button ButtonSum = new Button("+");
  private Button ButtonSub = new Button("-");
  private Button ButtonDiv = new Button("/");
  private Button ButtonMult = new Button("X");
  private Button ButtonCls = new Button("Cls");
  private Label labelResult = new Label("Resposta");  
  
  public void onModuleLoad() {
	mainPanel.add(TxtNum1);
    mainPanel.add(TxtNum2);
    mainPanel.add(PanelHorizontal);
    mainPanel.add(labelResult);
    mainPanel.add(TxtResult);
    
	PanelHorizontal.add(ButtonSum);
	PanelHorizontal.add(ButtonSub);
	PanelHorizontal.add(ButtonDiv);
	PanelHorizontal.add(ButtonMult);
	PanelHorizontal.add(ButtonCls);
	
	TxtResult.setEnabled(false);
	
    ButtonSum.addClickListener(new ClickListener(){
      public void onClick(Widget sender) {  
        doOperation(OPERATION.ADD);	  
      }
    });
    
    ButtonSub.addClickListener(new ClickListener(){
        public void onClick(Widget sender) {  
          doOperation(OPERATION.SUB);	  
        }
    });
    
    ButtonDiv.addClickListener(new ClickListener(){
        public void onClick(Widget sender) {
          doOperation(OPERATION.DIV);	  
        }
    });
    
    ButtonMult.addClickListener(new ClickListener(){
        public void onClick(Widget sender) {  
          doOperation(OPERATION.MULTP);	  
        }
    });
    
    ButtonCls.addClickListener(new ClickListener(){
        public void onClick(Widget sender) {
          clearTxtField();	  
        }
    });
    
    RootPanel.get("calc").add(mainPanel);
	TxtNum1.setFocus(true);
  }
  
  private void clearTxtField(){
    TxtNum1.setText("");
    TxtNum2.setText("");
    TxtResult.setText("");
    TxtNum1.setFocus(true);
  }
  
  private void doOperation(OPERATION f){
    int n1, n2, resp = 0; 
    String str1, str2, str_resp;
    str1 = "";
    str2 = "";
    str_resp = "";
    
    if ((TxtNum1.getText().length() != 0)&&(TxtNum2.getText().length() != 0)){
      str1 = TxtNum1.getText();
      str2 = TxtNum2.getText();
      n1 = Integer.parseInt(str1);
      n2 = Integer.parseInt(str2);
      switch (f){
        case ADD:
          resp = n1 +  n2;	
          break;	
        case SUB:
          resp = n1 -  n2;
          break;	
        case MULTP:
          resp = n1 *  n2;  
          break;	
        case DIV:
          resp = n1 /  n2; 
          break; 	
      }
      str_resp = Integer.toString(resp);
      TxtResult.setText(str_resp);
    }  
    else{
      Window.alert("Digite um valor valido!");
      clearTxtField();
    }
  }
}
