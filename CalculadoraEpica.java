import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CalculadoraEpica extends JFrame implements ActionListener {

    JButton btnsuma,btnresta,btnmulti,btndiv,btnlimpiar,btnsalir;
    JTextField valor1,valor2,camporesultado;
    JLabel label1,label2;
  
 
   public void Controles(){
   
      Container contenedor = getContentPane();
      contenedor.setLayout( new FlowLayout());
      
      label1 = new JLabel("Numero 1");
      contenedor.add(label1);
      
      valor1 = new JTextField(10);
      contenedor.add(valor1);
      
      label2 = new JLabel("Numero 2");
      contenedor.add(label2);
      
      valor2 = new JTextField(10);
      contenedor.add(valor2);
      
      btnsuma = new JButton("+");
      btnsuma.setBackground(Color.gray);
      contenedor.add(btnsuma);
      btnsuma.addActionListener(this);
      
      
      btnresta = new JButton("-");
      btnresta.setBackground(Color.gray);
      contenedor.add(btnresta);
      btnresta.addActionListener(this);
      
      btnmulti = new JButton("x");
      btnmulti.setBackground(Color.gray);
      contenedor.add(btnmulti);
      btnmulti.addActionListener(this);
      
      btndiv = new JButton("/");
      btndiv.setBackground(Color.gray);
      btndiv.addActionListener(this);
      contenedor.add(btndiv);

      camporesultado = new JTextField(10);
      contenedor.add(camporesultado);
      
      btnlimpiar = new JButton("Limpiar");
      btnlimpiar.setBackground(Color.green);
      contenedor.add(btnlimpiar);
      btnlimpiar.addActionListener(this);
      
      btnsalir=new JButton("Salir");
      btnsalir.setBackground(Color.red);
      contenedor.add(btnsalir);
      btnsalir.addActionListener(this);
   }
  
   public CalculadoraEpica(){
  
      super("Calculadora");
      //cargo controles
      Controles();
      setSize(220,200);
      setLocationRelativeTo(null);//Centrar ventana
      setVisible(true);
    }
  
   public void actionPerformed(ActionEvent e) {
     double  num1,num2,resu;
     String resultado;
     if (e.getSource()==btnsuma) {
      if(valor1.getText().equals("") || valor2.getText().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Los datos no están completos",
          "Error",JOptionPane.WARNING_MESSAGE); 
         }
         else{
          num1=Double.parseDouble(valor1.getText());
          num2=Double.parseDouble(valor2.getText());
          resu=num1+num2;
          resultado=String.valueOf(resu);
          camporesultado.setText(resultado);
         }          
          }
          else  
        if(valor2.getText().equals("0")) {
        JOptionPane.showMessageDialog(null, "La división entre 0 no es posible",
         "Error",JOptionPane.ERROR_MESSAGE);
            valor2.setText(null);
            valor2.requestFocus();
        }
        
      if (e.getSource()==btnresta) {
         if(valor1.getText().equals("") || valor2.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Los datos no están completos",
         "Error",JOptionPane.ERROR_MESSAGE); 
         }
         else{
          num1=Double.parseDouble(valor1.getText());
          num2=Double.parseDouble(valor2.getText());
          resu=num1-num2;
          resultado=String.valueOf(resu);
          camporesultado.setText(resultado);
         }          
        } 
        if (e.getSource()==btnmulti) {
         if(valor1.getText().equals("") || valor2.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Los datos no están completos",
          "Error",JOptionPane.ERROR_MESSAGE); 
         }
         else{
          num1=Double.parseDouble(valor1.getText());
          num2=Double.parseDouble(valor2.getText());
          resu=num1*num2;
          resultado=String.valueOf(resu);
          camporesultado.setText(resultado);
         }          
        }
        if (e.getSource()==btndiv) {
         if(valor1.getText().equals("") || valor2.getText().equals(""))
         {
          JOptionPane.showMessageDialog(null, "Los datos no están completos",
          "Error",JOptionPane.ERROR_MESSAGE);
         }
         
         else{
          num1=Double.parseDouble(valor1.getText());
          num2=Double.parseDouble(valor2.getText());
          try{
           resu=num1/num2;
           resultado=String.valueOf(resu);
           camporesultado.setText(resultado);
          }
          catch(ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "División entre cero NO PERMITIDA!",
            "Error",JOptionPane.ERROR_MESSAGE);
          }
           
         }  
        }
         
        if (e.getSource()==btnlimpiar){
         valor1.setText("");
            valor2.setText("");
            camporesultado.setText("");
       } 
        if(e.getSource()==btnsalir)
        {
         System.exit(0);   
        }
    }
}