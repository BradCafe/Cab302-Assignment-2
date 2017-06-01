
package asgn2GUIs;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A - Dietriche Rausim and Person B - Bradley Caferra
 *
 */
public class PizzaGUI extends javax.swing.JFrame {
	
    
    private javax.swing.JButton loadLogBtn;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel totalProfitLbl;
    private javax.swing.JLabel totalDistLbl;
    private javax.swing.JLabel customerRecordLbl;
    private javax.swing.JLabel pizzaOrderLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable customerTbl;
    private javax.swing.JTable orderTbl;
    private javax.swing.JTextField filePathFld;
    private javax.swing.JTextField totalProfitFld;
    private javax.swing.JTextField deliveryDistanceFld;
	
	private static final long serialVersionUID = 1L;
	
	private PizzaRestaurant restaurant = new PizzaRestaurant();
	/**
     * Creates new form PizzaGUI
     */
    public PizzaGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        filePathFld = new javax.swing.JTextField();
        loadLogBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTbl = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        calculateBtn = new javax.swing.JButton();
        totalProfitLbl = new javax.swing.JLabel();
        totalDistLbl = new javax.swing.JLabel();
        totalProfitFld = new javax.swing.JTextField();
        deliveryDistanceFld = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        customerRecordLbl = new javax.swing.JLabel();
        pizzaOrderLbl = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizza Place");

        loadLogBtn.setText("Browse");
        loadLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	loadLogBtnActionPerformed(evt);
            }
        });

        customerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Mobile Number", "X Location", "Y Location", "Distance"
            }
        ));
        jScrollPane1.setViewportView(customerTbl);

        calculateBtn.setText("Calculate Total");
        calculateBtn.setEnabled(false);
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	calculateBtnActionPerformed(evt);
            }
        });

        totalProfitLbl.setText("Total Profit");

        totalDistLbl.setText("Total Distance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(calculateBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalDistLbl)
                    .addComponent(totalProfitLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalProfitFld, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(182, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deliveryDistanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalProfitLbl)
                            .addComponent(totalProfitFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryDistanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalDistLbl)))
                    .addComponent(calculateBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"
            }
        ));
        jScrollPane2.setViewportView(orderTbl);

        customerRecordLbl.setText("Customer Records");

        pizzaOrderLbl.setText("Pizza Orders");

        resetBtn.setText("Reset");
        resetBtn.setEnabled(false);
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(filePathFld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadLogBtn))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(customerRecordLbl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pizzaOrderLbl, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadLogBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerRecordLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pizzaOrderLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resetBtn)))
                .addContainerGap())
        );

        pack();
    }

    private void loadLogBtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Click");
        JFileChooser  fileDialog = new JFileChooser("Open File");
        int returnVal = fileDialog.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
               filePathFld.setText(fileDialog.getSelectedFile().getPath());
               loadfile(fileDialog.getSelectedFile().getPath());
               calculateBtn.setEnabled(true);
               resetBtn.setEnabled(true);
               loadLogBtn.setEnabled(false);
            } else {
               System.out.println("Open command cancelled by user." );           
            }
        
    }

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
        reset();
    }
    
    private void reset(){
    	 DefaultTableModel customerTableModel = (DefaultTableModel) customerTbl.getModel();
         customerTableModel.setRowCount(0);
         DefaultTableModel pizzaTableModel = (DefaultTableModel) orderTbl.getModel();
         pizzaTableModel.setRowCount(0);
         filePathFld.setText("");
         totalProfitFld.setText("");
         deliveryDistanceFld.setText("");
         loadLogBtn.setEnabled(true);
         calculateBtn.setEnabled(false);
         resetBtn.setEnabled(false);       
    }

    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        totalProfitFld.setText(""+restaurant.getTotalProfit());
        deliveryDistanceFld.setText(""+restaurant.getTotalDeliveryDistance());
    }

    public void loadfile(String fileName){
        
        try {
            if(restaurant.processLog(fileName)){
                populateTables();
            }
        } catch (CustomerException ex) {
        	JOptionPane.showMessageDialog(new JFrame(),"Invalid Customer", "Error", JOptionPane.ERROR_MESSAGE);
        	//reset
        	reset();
        	
            Logger.getLogger(PizzaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PizzaException ex) {
        	JOptionPane.showMessageDialog(new JFrame(),"Invalid Pizza", "Error", JOptionPane.ERROR_MESSAGE);
        	//reset
        	reset();
        	
        	Logger.getLogger(PizzaGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LogHandlerException ex) {
        	JOptionPane.showMessageDialog(new JFrame(),"Invalid Customer", "Error", JOptionPane.ERROR_MESSAGE);
        	//reset
        	reset();
        	
        	Logger.getLogger(PizzaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void populateTables(){
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTbl.getModel();
        Object customerRowData[] = new Object[5];
        for(int i =0;i<restaurant.getNumCustomerOrders();i++){
            try {
                customerRowData[0] = restaurant.getCustomerByIndex(i).getName();
                customerRowData[1] = restaurant.getCustomerByIndex(i).getMobileNumber();
                customerRowData[2] = restaurant.getCustomerByIndex(i).getLocationX();
                customerRowData[3] = restaurant.getCustomerByIndex(i).getLocationY();
                customerRowData[4] = restaurant.getCustomerByIndex(i).getDeliveryDistance();
                customerTableModel.addRow(customerRowData);
            } catch (CustomerException ex) {
                Logger.getLogger(PizzaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        DefaultTableModel pizzaTableModel = (DefaultTableModel) orderTbl.getModel();
        Object pizzaRowData[] = new Object[5];
        for(int i=0; i <restaurant.getNumPizzaOrders();i++){
            try {
                pizzaRowData[0] = restaurant.getPizzaByIndex(i).getPizzaType();
                pizzaRowData[1] = restaurant.getPizzaByIndex(i).getQuantity();
                pizzaRowData[2] = restaurant.getPizzaByIndex(i).getOrderPrice();
                pizzaRowData[3] = restaurant.getPizzaByIndex(i).getCostPerPizza();
                pizzaRowData[4] = restaurant.getPizzaByIndex(i).getOrderProfit();
                pizzaTableModel.addRow(pizzaRowData);

            } catch (PizzaException ex) {
                Logger.getLogger(PizzaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
   

}

