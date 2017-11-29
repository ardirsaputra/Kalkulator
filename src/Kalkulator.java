import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
	public class Kalkulator {
		public static void main(String[]args) {
			JFrame Layar = new JFrame("Kalkulator");
			Layar.setType(Type.NORMAL);
			Layar.setResizable(false);
			Layar.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			Layar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			kalkulator isi = new kalkulator();
			Layar.setIconImage(Toolkit.getDefaultToolkit().getImage(Kalkulator.class.getResource("/Resources/iconkalkulator.png")));
			Layar.getContentPane().add(isi, BorderLayout.CENTER);
			isi.setLayout(null);
			Layar.setSize(428,255);
			Layar.setVisible(true);
			Layar.setLocation(470,265);
		}
	}
