package bsu.rfe.java.group5.lab2.Borovik.varB2;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import static java.lang.Math.*;

public class MainFrame extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 640;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	private JTextField text_mem1;
    private JTextField text_mem2;
    private JTextField text_mem3;
	private JTextField textFieldResult;
	private ButtonGroup radioButtons = new ButtonGroup();
	private ButtonGroup radioButtonsMem = new ButtonGroup();
	private Box hboxFormulaType = Box.createHorizontalBox();
	private Box hboxMemoryType = Box.createHorizontalBox();
	private int formulaId = 1;
	 private int formulaId_memory = 1;
	public Double calculate1(Double x, Double y,Double z) {
		return (pow((log(z)+sin((PI)*pow(z,2))),(1/4)))/(pow((pow(y,2)+exp(cos(x))+sin(y)),sin(x)));
		}
	public Double calculate2(Double x, Double y,Double z) {
		return sqrt(y)*((3*pow(z,x))/sqrt(1+pow(y,3)));
		}
	private void add_radio_button_memory(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId_memory = formulaId;
            }
        });
        radioButtonsMem.add(button);
        hboxMemoryType.add(button);
    }
	private void addRadioButton(String buttonName, final int formulaId) {
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			        MainFrame.this.formulaId = formulaId;
			     }
			});
			radioButtons.add(button);
			hboxFormulaType.add(button);
			
	}
	public MainFrame() {
		super("Вычисление формулы");
		setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width - WIDTH)/2,
				(kit.getScreenSize().height - HEIGHT)/2);
				hboxFormulaType.add(Box.createHorizontalGlue());
				addRadioButton("Формула 1", 1);
				addRadioButton("Формула 2", 2);
				radioButtons.setSelected(
				radioButtons.getElements().nextElement().getModel(), true);
				hboxFormulaType.add(Box.createHorizontalGlue());
				hboxFormulaType.setBorder(
				BorderFactory.createLineBorder(Color.YELLOW));
				JLabel labelForX = new JLabel("X:");
				textFieldX = new JTextField("0", 10);
				textFieldX.setMaximumSize(textFieldX.getPreferredSize());
				JLabel labelForY = new JLabel("Y:");
				textFieldY = new JTextField("0", 10);
				textFieldY.setMaximumSize(textFieldY.getPreferredSize());
				JLabel labelForZ = new JLabel("Z:");
				textFieldZ = new JTextField("0", 10);
				textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
				Box hboxVariables = Box.createHorizontalBox();
				hboxVariables.setBorder(
				BorderFactory.createLineBorder(Color.RED));
				hboxVariables.add(Box.createHorizontalGlue());
				hboxVariables.add(labelForX);
				hboxVariables.add(Box.createHorizontalStrut(10));
				hboxVariables.add(textFieldX);
				hboxVariables.add(Box.createHorizontalStrut(10));
				hboxVariables.add(labelForY);
				hboxVariables.add(Box.createHorizontalStrut(10));
				hboxVariables.add(textFieldY);
				hboxVariables.add(Box.createHorizontalStrut(10));
				hboxVariables.add(labelForZ);
				hboxVariables.add(Box.createHorizontalStrut(10));
				hboxVariables.add(textFieldZ);
				hboxVariables.add(Box.createHorizontalGlue());
				hboxMemoryType.add(Box.createHorizontalGlue());
				add_radio_button_memory("mem1",1);
				add_radio_button_memory("mem2",2);
				add_radio_button_memory("mem3",3);
				radioButtonsMem.setSelected(radioButtonsMem.getElements().nextElement().getModel(), true);
				hboxMemoryType.add(Box.createHorizontalGlue());
				hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.PINK));
			    JLabel label_mem1 = new JLabel("mem1:");
			    text_mem1 = new JTextField("0", 12);
			    text_mem1.setMaximumSize(text_mem1.getPreferredSize());
			    JLabel label_mem2 = new JLabel("mem2:");
			    text_mem2 = new JTextField("0", 12);
			    text_mem2.setMaximumSize(text_mem2.getPreferredSize());
			    JLabel label_mem3 = new JLabel("mem3:");
			    text_mem3 = new JTextField("0", 12);
			    text_mem3.setMaximumSize(text_mem3.getPreferredSize());
			    Box hboxForMemory = Box.createHorizontalBox();
		        hboxForMemory.add(label_mem1);
		        hboxForMemory.add(Box.createHorizontalStrut(15));
		        hboxForMemory.add(text_mem1);
		        hboxForMemory.add(Box.createHorizontalGlue());
		        hboxForMemory.add(label_mem2);
		        hboxForMemory.add(Box.createHorizontalStrut(15));
		        hboxForMemory.add(text_mem2);
		        hboxForMemory.add(Box.createHorizontalGlue());
		        hboxForMemory.add(label_mem3);
		        hboxForMemory.add(Box.createHorizontalStrut(15));
		        hboxForMemory.add(text_mem3);
		        text_mem1.setEnabled(false);
		        text_mem2.setEnabled(false);
		        text_mem3.setEnabled(false);
				JLabel labelForResult = new JLabel("Результат:");
				textFieldResult = new JTextField("0", 10);
				textFieldResult.setMaximumSize(
				textFieldResult.getPreferredSize());
				Box hboxResult = Box.createHorizontalBox();
				hboxResult.add(Box.createHorizontalGlue());
				hboxResult.add(labelForResult);
				hboxResult.add(Box.createHorizontalStrut(10));
				hboxResult.add(textFieldResult);
				hboxResult.add(Box.createHorizontalGlue());
				hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
				JButton buttonCalc = new JButton("Вычислить");
				buttonCalc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
				try {
				 Double x = Double.parseDouble(textFieldX.getText());
				 Double y = Double.parseDouble(textFieldY.getText());
				 Double z = Double.parseDouble(textFieldZ.getText());
				 Double result;
				 
				 if (formulaId==1)
				result = calculate1(x, y, z);
				 else
				result = calculate2(x, y ,z);
				 textFieldResult.setText(result.toString());
				} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(MainFrame.this,
				"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
				JOptionPane.WARNING_MESSAGE);
				}
				}
				});
				JButton buttonReset = new JButton("Очистить поля");
				buttonReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
				textFieldX.setText("0");
				textFieldY.setText("0");
				textFieldZ.setText("0");
				textFieldResult.setText("0");
				}
				});
				JButton buttonMC = new JButton("MC");
			    buttonMC.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent ev) {
			    try {
			    if (formulaId_memory == 1)
			    text_mem1.setText("0");
			    else if (formulaId_memory == 2)
			    text_mem2.setText("0");
			    else
			    text_mem3.setText("0");
			    } catch (NumberFormatException ex) {
			      JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
			    }
			    }
			    });
			    JButton buttonMPlus = new JButton("M+");
		        buttonMPlus.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent event) {
		        try {
		        Double result = Double.parseDouble(textFieldResult.getText());
		        if (formulaId_memory == 1)
		           text_mem1.setText(Double.toString(Double.parseDouble(text_mem1.getText()) + result));
		        else if (formulaId_memory == 2)
		           text_mem2.setText(Double.toString(Double.parseDouble(text_mem2.getText()) + result));
		        else
		           text_mem3.setText(Double.toString(Double.parseDouble(text_mem3.getText()) + result));
		        textFieldResult.setText(result.toString());
		        } catch (NumberFormatException ex) {
		           JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
		        }
		        }
		        });
				Box hboxButtons = Box.createHorizontalBox();
				hboxButtons.add(Box.createHorizontalGlue());
				hboxButtons.add(buttonCalc);
				hboxButtons.add(Box.createHorizontalStrut(30));
				hboxButtons.add(buttonReset);
				hboxButtons.add(Box.createHorizontalStrut(30));
				hboxButtons.add(buttonMPlus);
				hboxButtons.add(Box.createHorizontalStrut(30));
				hboxButtons.add(buttonMC);
				hboxButtons.add(Box.createHorizontalGlue());
				hboxButtons.setBorder(
				BorderFactory.createLineBorder(Color.GREEN));
				Box contentBox = Box.createVerticalBox();
				contentBox.add(Box.createVerticalGlue());
				contentBox.add(hboxFormulaType);
				contentBox.add(hboxVariables);
				contentBox.add(hboxResult);
				contentBox.add(hboxForMemory);
				contentBox.add(hboxMemoryType);
				contentBox.add(hboxButtons);
				contentBox.add(Box.createVerticalGlue());
				getContentPane().add(contentBox, BorderLayout.CENTER);
				}
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}



	

}
