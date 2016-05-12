import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class DayOfTheWeekService implements Service
{
    JLabel outputLabel;
    JComboBox month;
    JTextField day;
    JTextField year;
    
    public JPanel getGuiPanel()
    {
        JPanel panel=new JPanel();
        JButton button=new JButton();
        button.addActionListener(new DoItListener());
        outputLabel=new JLabel("date appears here");
        DateFormatSymbols dateStuff=new DateFormatSymbols();
        month=new JComboBox(dateStuff.getMonths());
        day=new JTextField(8);
        year=new JTextField(8);
        JPanel inputPanel=new JPanel(new GridLayout(3,2));
        inputPanel.add(new JLabel("Month"));
        inputPanel.add(month);
        inputPanel.add(new JLabel("Day"));
        inputPanel.add(day);
        inputPanel.add(new JLabel("Year"));
        inputPanel.add(button);
        inputPanel.add(outputLabel);
        return panel;
    }
    
    public class DoItListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            int monthNum=month.getSelectedIndex();
            int dayNum=Integer.parseInt(day.getText());
            int yearNum=Integer.parseInt(year.getText());
            Calendar c=Calendar.getInstance();
            c.set(Calendar.MONTH,monthNum);
            c.set(Calendar.DAY_OF_MONTH,monthNum);
            c.set(Calendar.YEAR,yearNum);
            Date date=c.getTime();
            String dayOfWeek=(new SimpleDateFormat("EEE")).format(date);
            outputLabel.setText(dayOfWeek);
        }
    }
}