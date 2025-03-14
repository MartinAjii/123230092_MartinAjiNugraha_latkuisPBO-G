package latihankuis;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LandingPage extends JFrame implements ActionListener{
    JLabel lnamaMhs = new JLabel("Nama Mahasiswa:");
    JTextField namaMhsTF = new JTextField();
    
    JLabel lnim = new JLabel("NIM:");
    JTextField nimTF = new JTextField();
    
    JLabel lnilaiTgs = new JLabel("Nilai Tugas:");
    JTextField nilaiTgsTF = new JTextField();
    
    JLabel lnilaiQuiz = new JLabel("Nilai Quiz:");
    JTextField nilaiQuizTF = new JTextField();
    
    JLabel ltipeKls = new JLabel("Tipe Kelas:");
    JRadioButton prak = new JRadioButton("Kelas Praktikum");
    JRadioButton teori = new JRadioButton("Kelas Teori", true);
    
    JLabel lmatkul = new JLabel("Mata Kuliah:");
    String[] namaMatkul = {"PBO", "SCPK", "Algo Lanjut"};
    JComboBox matkulCB = new JComboBox(namaMatkul);
    
    JButton submit = new JButton("Submit");
    JButton logout = new JButton("Log-out");
    
    LandingPage(String username){
        setTitle("Halaman Input Nilai");
        setSize(480, 360);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        ButtonGroup group = new ButtonGroup();
        group.add(prak);
        group.add(teori);
        
        add(lnamaMhs);
        lnamaMhs.setBounds(10, 10, 150, 20);
        add(namaMhsTF);
        namaMhsTF.setBounds(170, 10, 150, 20);
        
        add(lnim);
        lnim.setBounds(10, 40, 150, 20);
        add(nimTF);
        nimTF.setBounds(170, 40, 150, 20);
        
        add(lnilaiTgs);
        lnilaiTgs.setBounds(10, 70, 150, 20);
        add(nilaiTgsTF);
        nilaiTgsTF.setBounds(170, 70, 150, 20);
        
        add(lnilaiQuiz);
        lnilaiQuiz.setBounds(10, 100, 150, 20);
        add(nilaiQuizTF);
        nilaiQuizTF.setBounds(170, 100, 150, 20);
        
        add(ltipeKls);
        ltipeKls.setBounds(10, 130, 150, 20);
        add(prak);
        prak.setBounds(170, 130, 150, 20);
        add(teori);
        teori.setBounds(170, 160, 150, 20);
        
        add(lmatkul);
        lmatkul.setBounds(10, 190, 150, 20);
        add(matkulCB);
        matkulCB.setBounds(170, 190, 150, 20);
        
        add(submit);
        submit.setBounds(140, 250, 80, 40);
        submit.addActionListener(this);
        add(logout);
        logout.setBounds(230, 250, 80, 40);
        logout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String nama = namaMhsTF.getText();
                String nim = nimTF.getText();
                String matkul = (String) matkulCB.getSelectedItem();
                double nilaiPraktikum = Double.parseDouble(nilaiTgsTF.getText());   //maaf mas ini di soalnya jika user milih kelas teori rumusnya kok nilai teori + nilai praktikum
                double nilaiTeori = Double.parseDouble(nilaiQuizTF.getText());      //padahal yang diinput nilai tugas sama quiz, mungkin terbalik atau salah ketik
                
                double totalNilai;
                if (teori.isSelected()) {
                    totalNilai = (0.3 * nilaiTeori) + (0.7 * nilaiPraktikum);
                } else {
                    totalNilai = (0.7 * nilaiTeori) + (0.3 * nilaiPraktikum);
                }
                
                String hasil = (totalNilai > 85) ? "PASS" : "NOT PASS";
                
                String message = "Nama: " + nama + "\n" +
                                "NIM: " + nim + "\n" +
                                "Mata Kuliah: " + matkul + "\n" +
                                "Total Nilai: " + totalNilai + "\n" +
                                "Hasil: " + hasil;
                
                JOptionPane.showMessageDialog(this, message, "Hasil Penilaian", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan nilai yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }  else if (e.getSource() == logout) {
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new LoginPage();
            }
        }
    }
}
