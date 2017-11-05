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
		layar.setFont(new Font("Dialog", Font.BOLD, 12));
		layar.setHorizontalAlignment(SwingConstants.RIGHT);
		layar.setBackground(UIManager.getColor("Button.light"));
		layar.setBounds(14, 15, 420, 25);
		layar.setEnabled(false);
		add(layar);
		final ActionListener tambahan = new insertAction();
		final ActionListener perintah = new commandAction();
		final ActionListener action = new Action();
		panel = new JPanel();
		panel.setFont(new Font("Noto Sans CJK TC Thin", Font.PLAIN, 12));
		panel.setBounds(14, 52, 420, 163);
		panel.setLayout(new GridLayout(6,5));
		addbutton("X.10^Y",perintah);
		addbutton("Phi",action);
		addbutton("Negasi",action);          
		addbutton("+1",action);            
		addbutton("reset",action);
		addbutton("X^Y",perintah);
		addbutton("Akar",action);          
		addbutton("Real",action);
		addbutton("-1",action);              
		addbutton("%",action);                  
		addbutton("sin",action);
		addbutton("7",tambahan);
		addbutton("8",tambahan);
		addbutton("9",tambahan);
		addbutton("/",perintah);
		addbutton("cos",action);
		addbutton("4",tambahan);
		addbutton("5",tambahan);
		addbutton("6",tambahan);
		addbutton("x",perintah);
		addbutton("tan",action);
		addbutton("1",tambahan);
		addbutton("2",tambahan);
		addbutton("3",tambahan);
		addbutton("+",perintah);
		addbutton("X!",action);            
		addbutton("0",tambahan);
		addbutton(".",tambahan);
		addbutton("=",perintah);
		addbutton("-",perintah);
		add(panel);
	}
	void addbutton (final String label,final ActionListener listener) {
		final JButton button = new JButton (label);
		button.setFont(new Font("Dialog", Font.PLAIN, 13));
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
		else if (Last.equals("X^Y")) {
			Hasil=Math.pow(Hasil,x);
		}
		else if (Last.equals("%")) {
			Hasil=x/100;
		}
		else if (Last.equals("X.10^Y")) {
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
			if (action.equals("-1")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = TempDouble - 1;
				Hasil = TempDouble;
				layar.setText(""+Hasil);
			}
			if (action.equals("+1")) {
				TempDouble = Double.parseDouble(layar.getText());
				TempDouble = TempDouble + 1;
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
			if (action.equals("X!")) {
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
