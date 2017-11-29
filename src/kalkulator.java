import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class kalkulator extends JPanel{
	private static final long serialVersionUID = 1L;
	JButton layar ;
	JPanel panel ; 
	double Hasil ; 
	String Last;
	boolean mulai;
	public kalkulator (){
		setBackground(UIManager.getColor("Button.shadow"));
		Hasil = 0;
		mulai = true;
		Last = "=";
		setLayout(null);
		layar = new JButton("0");
		layar.setFont(new Font("Dialog", Font.BOLD, 16));
		layar.setHorizontalAlignment(SwingConstants.RIGHT);
		layar.setBackground(UIManager.getColor("Button.light"));
		layar.setBounds(14, 15, 420, 32);
		layar.setEnabled(false);
		add(layar);
		final ActionListener tambahan = new insertAction();
		final ActionListener perintah = new commandAction();
		final ActionListener action = new Action();
		panel = new JPanel();
		panel.setBounds(14, 52, 420, 192);
		panel.setLayout(null);
		
		addbutton("x.10^y",perintah,0,0,80,32);
		addbutton("Phi",action,80, 0, 80,32);
		addbutton("Negasi",action,160,0,80,32);                   
		addbutton("reset",action,240,0,160,32);
		
		addbutton("x^y",perintah,0,32,80,32);
		addbutton("Akar",action,80,32,80,32);          
		addbutton("Real",action,160,32,80,32);              
		addbutton("C",action,240,32,80,32);  
		addbutton("%",action,320,32,80,32);
		
		addbutton("7",tambahan,0,64,80,32);
		addbutton("8",tambahan,80,64,80,32);
		addbutton("9",tambahan,160,64,80,32);
		addbutton("x",perintah,240,64,80,32);
		addbutton("X!",action,320,64,80,32);
		
		addbutton("4",tambahan,0,96,80,32);
		addbutton("5",tambahan,80,96,80,32);
		addbutton("6",tambahan,160,96,80,32);
		addbutton("/",perintah,240,96,80,32);
		addbutton("sin",action,320,96,80,32);
		
		addbutton("1",tambahan,0,128,80,32);
		addbutton("2",tambahan,80,128,80,32);
		addbutton("3",tambahan,160,128,80,32);
		addbutton("+",perintah,240,128,80,32);
		addbutton("cos",action,320,128,80,32);
		
		addbutton("0",tambahan,0,160,80,32);            
		addbutton(".",tambahan,80,160,80,32);
		addbutton("=",perintah,160,160,80,32);
		addbutton("-",perintah,240,160,80,32);
		addbutton("tan",action,320,160,80,32);
		
		add(panel);
	}
	void addbutton (final String label,final ActionListener listener,int a,int b,int c , int d) {
		final JButton button = new JButton (label);
		button.setFont(new Font("Dialog", Font.PLAIN, 13));
		button.setBounds(a,b,c,d);
		button.addActionListener(listener);
		panel.add(button);
	}
	public void proses(final double x) {
		
		if (Last.equals("+")) {
			Hasil=Hasil+x;
		}
		else if (Last.equals("-")) {
			Hasil=Hasil-x;
		}
		else if (Last.equals("x")) {
			Hasil=Hasil*x;
		}
		else if (Last.equals("/")) {
			Hasil=Hasil/x;
		}
		else if (Last.equals("=")) {
			Hasil=x;
		}
		else if (Last.equals("x^y")) {
			Hasil=Math.pow(Hasil,x);
		}
		else if (Last.equals("%")) {
			Hasil=x/100;
		}
		else if (Last.equals("x.10^y")) {
			final double by = Math.pow(10, x);
			Hasil = Hasil * by;
		}
		layar.setText(""+Hasil);
	}
	private class insertAction implements ActionListener {
		public void actionPerformed (final ActionEvent e) {
			final String input = e.getActionCommand();
			if (mulai) {
				layar.setText(" ");
				mulai=false;
			}
			layar.setText(layar.getText()+input);
		}
	}
	private class Action implements ActionListener {
		public void actionPerformed (final ActionEvent e) {
			final String action = e.getActionCommand();
			Double TempDouble;
			if (action.equals("Phi")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = TempDouble *22/7;
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if (action.equals("Negasi")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = TempDouble*-1.0;
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if (action.equals("Akar")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = Math.sqrt(TempDouble);
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if (action.equals("%")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = TempDouble/100;
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if (action.equals("Real")) {
				TempDouble = Double.parseDouble(layar.getText());
				int TempInt = (int) ((double)TempDouble*1);
				final Double TempHasil = TempDouble - TempInt;
				if (TempHasil >= 0.5 ) {
					TempDouble = TempDouble+1;
				}
				TempInt = (int) ((double)TempDouble*1);
				Hasil = TempInt;
				layar.setText(""+Hasil);
			}
			if (action.equals("reset")) {
				Hasil=0;
				layar.setText(""+Hasil);
				mulai=true;
			}
			if (action.equals("x!")) {
				TempDouble = Double.parseDouble(layar.getText());
				final int TempInt = (int)(TempDouble*1);
				Double TempHasil = 1.0;
				for(int i=0;i<TempInt;i++){
			        //mendapatkan angka perkalian suatu faktorial
			        final int temp=TempInt-i;
			        //melakukan penghitungan faktorial
			        TempHasil=TempHasil*temp;         
					}
				Hasil = TempHasil;
				layar.setText(""+Hasil);
			}
			if (action.equals("sin")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble=Math.sin(TempDouble);
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if(action.equals("tan")){
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble=Math.tan(TempDouble);
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if(action.equals("cos")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble=Math.cos(TempDouble);
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if(action.equals("C")) {
				String A = layar.getText();
				if (A.length()>0) {
					String TempString = layar.getText();
					String B = TempString.substring(0, TempString.length()-1);
					layar.setText(B);
				}
			}
		}
	}
	private class commandAction implements ActionListener {
		public void actionPerformed (final ActionEvent e) {
			final String command = e.getActionCommand();
			if(mulai) {
				if (command.equals("=")) {
					mulai=false;
				}
				else
					Last=command;
			}
			else
			{	
				proses(Double.parseDouble(layar.getText()));		
				Last=command;
				mulai= true;
			}
		}
	}
}
