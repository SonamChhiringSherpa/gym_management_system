import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class GymGUI{
    ArrayList<GymMember> memberList = new ArrayList<>();
    

    private JFrame newFrame = new JFrame();
    private JFrame frame;
    private JFrame r;
    private JFrame p;
    public GymMember searchMember(int id){
        for (GymMember i : memberList){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }
    public GymGUI(){
        JFrame frame = new JFrame();
        frame.setBounds(700,100,1000,600);
        frame.setTitle("Gym GUI");
        frame.setResizable(false);
        frame.setLayout(null);
        
        homePanel();
        
    }
    
    public void homePanel(){
        JFrame frame = new JFrame();
        frame.setBounds(700,100,1000,600);
        frame.setTitle("Gym GUI");
        frame.setResizable(false);
        frame.setLayout(null);
        
        JPanel home = new JPanel();
        home.setBounds(0,0,1000,600);
        home.setLayout(null);
        frame.add(home);
        
        //panel that contains the header label
        JPanel titlepanel = new JPanel();
        titlepanel.setBounds(0,0,1000,100);
        titlepanel.setLayout(null);
        Color titlecolor = new Color(0, 0, 0 );
        titlepanel.setBackground(titlecolor);
        home.add(titlepanel);
        
        //top header label
        JLabel topLabel = new JLabel("Gym Membership Management");
        topLabel.setBounds(300,0,1000,100);
        topLabel.setFont(new Font("Arial", Font.BOLD,30));
        topLabel.setForeground(Color.white);
        titlepanel.add(topLabel);
        
        //a panel to put background image
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0,100,1000,600);
        buttonPanel.setLayout(null);
        Color bg = new Color(162, 159, 159 );
        buttonPanel.setBackground(bg);
        home.add(buttonPanel);
        
        //
        ImageIcon icon = new ImageIcon("./bgimage.jpg");
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        
        //creating bgimage label to add image inside the label
        JLabel bgimage = new JLabel();
        bgimage.setBounds(0,0,1000,600);
        bgimage.setIcon(resizedicon);
        buttonPanel.add(bgimage); // adding the image label to the background image panel
        
        
        //Regular member button
        JButton regularmember = new JButton("Add Regular Member");
        regularmember.setBounds(370,100,250,60);
        regularmember.setFont(new Font("Arial",Font.PLAIN, 18));
        bgimage.add(regularmember);
        regularmember.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                regularPanel();
            }
            
        });
        
        //Premium member button
        JButton premiummember = new JButton("Add Premium Member");
        premiummember.setBounds(370,180,250,60);
        premiummember.setFont(new Font("Arial",Font.PLAIN, 18));
        premiummember.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                premiumPanel();
            }
            
        });
        bgimage.add(premiummember);
        
      
        JButton displayFromfile = new JButton("Display from File");
        displayFromfile.setBounds(370,260,250,60);
        displayFromfile.setFont(new Font("Arial",Font.PLAIN, 18));
        bgimage.add(displayFromfile);
        displayFromfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("MemberDetails.txt");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                JFrame frame = new JFrame("Member Details From File");
                frame.setSize(1000, 600);
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                frame.add(scrollPane);
        
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    StringBuilder fileContent = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line).append("\n");
                    }
                    textArea.setText(fileContent.toString());
                    frame.setVisible(true);
        
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        
        home.setVisible(true);
        frame.setVisible(true);
    }
    
    
    public void regularPanel(){
        JFrame r = new JFrame();
        r.setBounds(700,100,1000,600);
        r.setTitle("Regular Member Registration");
        r.setResizable(false);
        r.setLayout(null);
        
        JPanel rm = new JPanel();
        rm.setBounds(0,0,1000,600);
        rm.setLayout(null);
        r.add(rm); //adding panel to the frame
        
        ImageIcon icon = new ImageIcon("./rbgimage.jpg");
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        
        //creating bgimage label to add image inside the label
        JLabel bgimage = new JLabel();
        bgimage.setBounds(0,0,1000,600);
        bgimage.setIcon(resizedicon);
        rm.add(bgimage); // adding the image label to the rm panel
        
        //back button
        JButton back = new JButton("Back");
        back.setBounds(20,20,100,30);
        back.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                r.setVisible(false);
                homePanel();
            }
            
        });
        bgimage.add(back);
        
        JLabel title = new JLabel("Regular Member Registration");
        title.setBounds(300,10,500,40);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial",Font.BOLD, 30));
        bgimage.add(title);
        
        //id
        JLabel id = new JLabel("ID: ");
        id.setBounds(30,70,100,30);
        id.setFont(new Font("Arial",Font.BOLD,15));
        id.setForeground(Color.white);
        bgimage.add(id);
        //idfield
        JTextField idF = new JTextField();
        idF.setBounds(140,70,200,30);
        bgimage.add(idF);
        
        //name
        JLabel name = new JLabel("Name: ");
        name.setBounds(30,110,100,30);
        name.setFont(new Font("Arial",Font.BOLD,15));
        name.setForeground(Color.white);
        bgimage.add(name);
        //nameField
        JTextField nameF = new JTextField();
        nameF.setBounds(140,110,200,30);
        bgimage.add(nameF);
        
        //location
        JLabel location = new JLabel("Location: ");
        location.setBounds(30,150,100,30);
        location.setFont(new Font("Arial",Font.BOLD,15));
        location.setForeground(Color.white);
        bgimage.add(location);
        //location field
        JTextField locationF = new JTextField();
        locationF.setBounds(140,150,200,30);
        bgimage.add(locationF);
        
        //Phone
        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30,190,100,30);
        phone.setFont(new Font("Arial",Font.BOLD,15));
        phone.setForeground(Color.white);
        bgimage.add(phone);
        //phone field
        JTextField phoneF = new JTextField();
        phoneF.setBounds(140,190,200,30);
        bgimage.add(phoneF);
        
        //Email
        JLabel email = new JLabel("Email: ");
        email.setBounds(30,230,100,30);
        email.setFont(new Font("Arial",Font.BOLD,15));
        email.setForeground(Color.white);
        bgimage.add(email);
        //email field
        JTextField emailF = new JTextField();
        emailF.setBounds(140,230,200,30);
        bgimage.add(emailF);
        
        //gender label
        JLabel gender = new JLabel("Select Gender:");
        gender.setBounds(30,270,110,30);
        gender.setFont(new Font("Arial",Font.BOLD,15));
        gender.setForeground(Color.white);
        bgimage.add(gender);
        //radio button
        JRadioButton r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.BOLD,15));
        r1.setForeground(Color.white);
        r1.setBounds(145,270,100,30);
        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(210,270,100,30);
        r2.setFont(new Font("Arial",Font.BOLD,15));
        r2.setForeground(Color.white);
        bgimage.add(r1);
        bgimage.add(r2);
        //grouping the radio button
        ButtonGroup rg = new ButtonGroup();
        rg.add(r1);
        rg.add(r2);
        
        //dob
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(30,310,100,30);
        dobLabel.setFont(new Font("Arial",Font.BOLD,15));
        dobLabel.setForeground(Color.white);
        bgimage.add(dobLabel);
        
        JPanel dobPanel = new JPanel();
        dobPanel.setBounds(200,310,258,30);
        dobPanel.setBackground(new Color(63, 63, 62 ,100));
        JComboBox<String> dayBox = new JComboBox<>(new String[]{"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        JComboBox<String> monthBox = new JComboBox<>(new String[]{"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        JComboBox<String> yearBox = new JComboBox<>(new String[]{"","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"});
        dobPanel.add(dayBox);
        dobPanel.add(monthBox);
        dobPanel.add(yearBox);
        bgimage.add(dobPanel); //adding dobpanel to the rmpanel
        
        JLabel Mship = new JLabel("Membership Start Date:");
        Mship.setBounds(30,350,200,30);
        Mship.setFont(new Font("Arial",Font.BOLD,15));
        Mship.setForeground(Color.white);
        bgimage.add(Mship);
        
        JPanel MshipPanel = new JPanel();
        MshipPanel.setBounds(200,350,258,30);
        MshipPanel.setBackground(new Color(63, 63, 62 ,100));
        JComboBox<String> dayBox1 = new JComboBox<>(new String[]{"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        JComboBox<String> monthBox1 = new JComboBox<>(new String[]{"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        JComboBox<String> yearBox1 = new JComboBox<>(new String[]{"","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"});
        MshipPanel.add(dayBox1);
        MshipPanel.add(monthBox1);
        MshipPanel.add(yearBox1);
        bgimage.add(MshipPanel); //adding Mship panel to the rm panel
        
        //plan label
        JLabel plan = new JLabel("Plan:");
        plan.setBounds(30,390,100,30);
        plan.setFont(new Font("Arial",Font.BOLD,15));
        plan.setForeground(Color.white);
        bgimage.add(plan);
        //plan combobox
        JPanel planCombobox = new JPanel();
        planCombobox.setBounds(150,390,100,30);
        planCombobox.setBackground(new Color(63, 63, 62 ,100));
        JComboBox<String> plancombo = new JComboBox<>(new String[]{"","Basic","Standard","Delux"});
        planCombobox.add(plancombo);
        bgimage.add(planCombobox);
        
        //referal resources
        JLabel refResource = new JLabel("Referal Resources:");
        refResource.setBounds(500,70,150,30);
        refResource.setFont(new Font("Arial",Font.BOLD,15));
        refResource.setForeground(Color.white);
        bgimage.add(refResource);
        //referal resources textfield
        JTextField refResourceF = new JTextField();
        refResourceF.setBounds(660,70,200,30);
        bgimage.add(refResourceF);
        
        //plan price
        JLabel planPrice = new JLabel("Plan Price: ");
        planPrice.setBounds(500,110,150,30);
        planPrice.setFont(new Font("Arial",Font.BOLD,15));
        planPrice.setForeground(Color.white);
        bgimage.add(planPrice);
        //planprice diplay
        JTextField planPriceF = new JTextField();
        planPriceF.setBounds(660,110,100,30);
        plancombo.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String plan=(String)plancombo.getSelectedItem();
               double planprice = 0;
               
               if(plan=="Basic"){
                   planprice = 6500;
               }
               else if(plan =="Standard"){
                   planprice = 12500;
               }
               else if(plan == "Delux"){
                   planprice = 18500;
               }
               
               planPriceF.setText(String.valueOf(planprice));
           }
        });
        bgimage.add(planPriceF);
        
        //paid amount
        JLabel paidAmount = new JLabel("Paid Amount:");
        paidAmount.setBounds(500,150,150,30);
        paidAmount.setFont(new Font("Arial",Font.BOLD,15));
        paidAmount.setForeground(Color.white);
        bgimage.add(paidAmount);
        //paid amount textfield
        JTextField paidAmountF = new JTextField();
        paidAmountF.setBounds(660,150,200,30);
        bgimage.add(paidAmountF);
        
        
        //add button
        JButton add = new JButton("Add");
        add.setBounds(30,430,100,40);
        add.setFont(new Font("Arial",Font.PLAIN,15));
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    if(idF.getText().isEmpty() || nameF.getText().isEmpty() ||locationF.getText().isEmpty() ||phoneF.getText().isEmpty() ||emailF.getText().isEmpty() ||refResourceF.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please fill the required fields.");
                        return;
                    }
                    //getting vlaues from inputfields
                    int id = Integer.parseInt(idF.getText());
                    String name = nameF.getText();
                    String location = locationF.getText();
                    String phone = phoneF.getText();
                    String email = emailF.getText();
                    String referralSource = refResourceF.getText();
                    
                    //getting the dob
                    if(dayBox.getSelectedItem()==null||monthBox.getSelectedItem()==null||yearBox.getSelectedItem()==null){
                        JOptionPane.showMessageDialog(r,"Please select date of birth");
                        return;
                    }
                    //getting dob and start date 
                    String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
                    String startDate = dayBox1.getSelectedItem() + "-" + monthBox1.getSelectedItem() + "-" + yearBox1.getSelectedItem();
                    //gettig gender
                    String Gender = r1.isSelected() ? "Male" :"Female";
                    
                    //checking duplicate id
                    boolean dId = false;
                    for(GymMember m : memberList){
                        if(m.getId() == id){
                            dId = true;
                            break;
                        }
                    }
                    if(dId){
                        JOptionPane.showMessageDialog(r,"Member with this id already exist");
                        return;
                    }
                    
                    //creating regularmember object
                    RegularMember newMember = new RegularMember(id, name, location, phone, email, Gender, dob, startDate, referralSource);

                    //add member to the memberlist
                    memberList.add(newMember);
                    
                    
                    JOptionPane.showMessageDialog(r,"Member added successfully");
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(r,"Please enter a valid id");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(r,"An error occured" +ex.getMessage());
                }
                
            }
        });
        bgimage.add(add);
        
        // //Activate member button for regular member
        JButton Activate = new JButton("Activate Membership");
        Activate.setBounds(190,430,190,40);
        Activate.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(Activate);
        Activate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to activate membership:");
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;
        
                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            found = true;
        
                            // Check if member is already active
                            if (member.getActiveStatus()) {
                                JOptionPane.showMessageDialog(null, "Membership is already active for ID: " + id);
                            } else {
                                member.activateMembership();
                                JOptionPane.showMessageDialog(null, "Membership activated for ID: " + id);
                            }
                            break; // exit loop after finding the member
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            }
        });

        //deactivate membership button
        JButton deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to deactivate membership:");
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;
        
                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            member.deactivateMembership();
                            JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + id);
                            found = true;
                            break;
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            }
        });
        deactivateButton.setBounds(390,430,190,40);
        deactivateButton.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(deactivateButton);
        
        //clear button for regular member
        // Clear Button
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(500, 350, 100, 30);
        clearBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        bgimage.add(clearBtn);
        // Clear Button ActionListener
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                idF.setText("");
                nameF.setText("");
                locationF.setText("");
                phoneF.setText("");
                emailF.setText("");
                rg.clearSelection(); // clears radio button selection
                dayBox.setSelectedIndex(0);
                monthBox.setSelectedIndex(0);
                yearBox.setSelectedIndex(0);
                dayBox1.setSelectedIndex(0);
                monthBox1.setSelectedIndex(0);
                yearBox1.setSelectedIndex(0);
                plancombo.setSelectedIndex(0);
                refResourceF.setText("");
                planPriceF.setText("");
                paidAmountF.setText("");
                
            }
        });

        //markattendance button for regular member
        JButton RmarkAttendance = new JButton("Mark Attendance");
        RmarkAttendance.setBounds(30,500,150,40);
        RmarkAttendance.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(RmarkAttendance);
        RmarkAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to mark attendance:");
                
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;
        
                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(null, "Attendance marked for Member ID: " + id);
                            found = true;
                            break;
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            }
        });
        
        //save to file regular
        JButton saveTofiles = new JButton("Save to File");
        saveTofiles.setBounds(190,500,150,40);
        saveTofiles.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(saveTofiles);
        saveTofiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("MemberDetails.txt", false))) {
                    String header = String.format(
                        "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Start Date", "Plan", "Price", "Attendance", "Loyalty", "Status"
                    );
                    writer.write(header);
                    
                    for (GymMember member : memberList) {
                        if (member instanceof RegularMember) {
                            RegularMember r = (RegularMember) member;
                            String status = r.getActiveStatus() ? "Active" : "Inactive";
                            String line = String.format(
                                "%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s\n",
                                r.getId(), r.getName(), r.getLocation(), r.getPhone(), r.getEmail(),
                                r.getMembershipStartDate(), r.getPlan(), r.getPrice(), r.getAttendance(),
                                r.getLoyaltyPoints(), status
                            );
                            writer.write(line);
                        }
                    }
        
                    JOptionPane.showMessageDialog(null, "Regular members saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving regular members: " + ex.getMessage());
                }
            }
        });


        
        //upgrade plan button
        JButton upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(350,500,150,40);
        upgradePlan.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(upgradePlan);
        upgradePlan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ask for Member ID via input dialog
                String enteredId = JOptionPane.showInputDialog(null, "Enter Member ID to upgrade plan:");
                if (enteredId == null || enteredId.trim().isEmpty()) {
                    
                    return;
                }
                enteredId = enteredId.trim();
        
                // Get plan from combo box
                String selectedPlan = (String) plancombo.getSelectedItem();
        
                // If plan selection is empty or null, ask user to input plan via JOptionPane
                if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                    String[] plans = {"Basic", "Standard", "Deluxe"};  // example plan options
                    selectedPlan = (String) JOptionPane.showInputDialog(null,
                        "Please select a plan to upgrade:",
                        "Select Plan",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        plans,
                        plans[0]);
        
                    if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No plan selected. Upgrade cancelled.");
                        return;
                    }
                }
                selectedPlan = selectedPlan.trim();
        
                boolean found = false;
        
                for (GymMember member : memberList) {
                    // Assuming GymMember or its child has getId() and getActiveStatus() methods
                    if (String.valueOf(member.getId()).equals(enteredId)) {
                        found = true;
        
                        // Check if member is active
                        if (member.getActiveStatus()) {
        
                            // Only RegularMember has upgradePlan method - so check instance type first
                            if (member instanceof RegularMember) {
                                RegularMember regularMember = (RegularMember) member;
                                String message = regularMember.upgradePlan(selectedPlan);
                                JOptionPane.showMessageDialog(null, message);
                            } else {
                                JOptionPane.showMessageDialog(null, "Plan upgrade is only available for Regular Members.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Member is not active. Cannot upgrade plan.");
                        }
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Member ID not found.");
                }
            }
        });



        
        //display button for regular member
        JButton display = new JButton("Display");
        display.setBounds(510,500,150,40);
        display.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to Display:", "Search Member", JOptionPane.PLAIN_MESSAGE);
        
                if (inputId == null || inputId.trim().isEmpty()) {
                    // if the User pressed cancel or didn't enter anything stop here else continue
                    return;
                }
        
                boolean found = false;
                JFrame displayData = new JFrame("Regular Member Info");
                displayData.setSize(400, 500);
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
        
                for (GymMember member : memberList) {
                    if (member instanceof RegularMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
                        RegularMember r = (RegularMember) member;
        
                        StringBuilder txt = new StringBuilder();
                        txt.append("ID: ").append(r.getId()).append("\n");
                        txt.append("Name: ").append(r.getName()).append("\n");
                        txt.append("Email: ").append(r.getEmail()).append("\n");
                        txt.append("Phone: ").append(r.getPhone()).append("\n");
                        txt.append("Attendance: ").append(r.getAttendance()).append("\n");
                        txt.append("Status: ").append(r.getActiveStatus() ? "Active" : "Inactive").append("\n");
                        txt.append("Type: Regular Member\n");
                        txt.append("Plan: ").append(r.getPlan()).append("\n");
                        txt.append("Plan Price: ").append(r.getPrice()).append("\n");
        
                        // Also show selected plan and price from combo box
                        String selectedPlan = (String) plancombo.getSelectedItem();
                        String selectedPlanPrice = planPriceF.getText();
        
                        if (selectedPlan != null && !selectedPlan.isEmpty() && !selectedPlanPrice.isEmpty()) {
                            txt.append("Selected Plan (from ComboBox): ").append(selectedPlan).append("\n");
                            txt.append("Selected Plan Price: ").append(selectedPlanPrice).append("\n");
                        }
        
                        displayArea.setText(txt.toString());
                        displayData.add(new JScrollPane(displayArea));
                        displayData.setVisible(true);
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No Regular Member found with ID: " + inputId, "Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        
        //revert regular membership button
        JButton revertMS = new JButton("Revert MemberShip");
        revertMS.setBounds(670,500,150,40);
        revertMS.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(revertMS);
        revertMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Regular Member ID to Revert:", "Revert Regular Member", JOptionPane.PLAIN_MESSAGE);
        
                if (inputId == null || inputId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Member ID is required.");
                    return;
                }
        
                boolean found = false;
        
                for (GymMember member : memberList) {
                    if (member instanceof RegularMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
        
                        String reason = JOptionPane.showInputDialog(null, "Enter removal reason:", "Removal Reason", JOptionPane.PLAIN_MESSAGE);
                        if (reason != null && !reason.trim().isEmpty()) {
                            RegularMember rm = (RegularMember) member;
                            rm.revertRegularMember(reason);
                            JOptionPane.showMessageDialog(null, "Regular Member reverted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Removal reason is required.");
                        }
        
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No Regular Member found with ID: " + inputId);
                }
            }
        });

    
        
        rm.setVisible(true);
        r.setVisible(true);
    }
    public void premiumPanel(){
        JFrame p = new JFrame();
        p.setBounds(700,100,1000,600);
        p.setTitle("Premium Member Registration");
        p.setResizable(false);
        p.setLayout(null);
        
        JPanel pm = new JPanel();
        pm.setBounds(0,0,1000,600);
        pm.setLayout(null);
        p.add(pm); //adding panel to the frame
        
        ImageIcon icon = new ImageIcon("//Users//sonamsherpa//Desktop//College//JAVA PROGRAMMING//COURSEWORK//GUI_CODE//24046648_SonamChhiringSherpa//rbgimage.jpg");
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(1000,600,Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        
        //creating bgimage label to add image inside the label
        JLabel bgimage = new JLabel();
        bgimage.setBounds(0,0,1000,600);
        bgimage.setIcon(resizedicon);
        pm.add(bgimage); // adding the image label to the rm panel
        
        //back button
        JButton back = new JButton("Back");
        back.setBounds(20,20,100,30);
        back.setFont(new Font("Arial",Font.PLAIN, 15));
        back.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                p.setVisible(false);
                homePanel();
            }
            
        });
        bgimage.add(back);
        
        JLabel title = new JLabel("Premium Member Registration");
        title.setBounds(300,10,500,40);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.white);
        bgimage.add(title);
        
        //id
        JLabel id = new JLabel("ID: ");
        id.setBounds(30,70,100,30);
        id.setFont(new Font("Arial",Font.BOLD,15));
        id.setForeground(Color.white);
        bgimage.add(id);
        //idfield
        JTextField idF = new JTextField();
        idF.setBounds(140,70,200,30);
        bgimage.add(idF);
        
        //name
        JLabel name = new JLabel("Name: ");
        name.setBounds(30,110,100,30);
        name.setFont(new Font("Arial",Font.BOLD,15));
        name.setForeground(Color.white);
        bgimage.add(name);
        //nameField
        JTextField nameF = new JTextField();
        nameF.setBounds(140,110,200,30);
        bgimage.add(nameF);
        
        //location
        JLabel location = new JLabel("Location: ");
        location.setBounds(30,150,100,30);
        location.setFont(new Font("Arial",Font.BOLD,15));
        location.setForeground(Color.white);
        bgimage.add(location);
        //location field
        JTextField locationF = new JTextField();
        locationF.setBounds(140,150,200,30);
        bgimage.add(locationF);
        
        //Phone
        JLabel phone = new JLabel("Phone: ");
        phone.setBounds(30,190,100,30);
        phone.setFont(new Font("Arial",Font.BOLD,15));
        phone.setForeground(Color.white);
        bgimage.add(phone);
        //phone field
        JTextField phoneF = new JTextField();
        phoneF.setBounds(140,190,200,30);
        bgimage.add(phoneF);
        
        //Email
        JLabel email = new JLabel("Email: ");
        email.setBounds(30,230,100,30);
        email.setFont(new Font("Arial",Font.BOLD,15));
        email.setForeground(Color.white);
        bgimage.add(email);
        //email field
        JTextField emailF = new JTextField();
        emailF.setBounds(140,230,200,30);
        bgimage.add(emailF);
        
        //gender label
        JLabel gender = new JLabel("Select Gender:");
        gender.setBounds(30,270,110,30);
        gender.setFont(new Font("Arial",Font.BOLD,15));
        gender.setForeground(Color.white);
        bgimage.add(gender);
        //radio button
        JRadioButton r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.BOLD,15));
        r1.setForeground(Color.white);
        r1.setBounds(145,270,100,30);
        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(210,270,100,30);
        r2.setFont(new Font("Arial",Font.BOLD,15));
        r2.setForeground(Color.white);
        bgimage.add(r1);
        bgimage.add(r2);
        //grouping the radio button
        ButtonGroup rg = new ButtonGroup();
        rg.add(r1);
        rg.add(r2);
        
        //dob
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(30,310,100,30);
        dobLabel.setFont(new Font("Arial",Font.BOLD,15));
        dobLabel.setForeground(Color.white);
        bgimage.add(dobLabel);
        
        JPanel dobPanel = new JPanel();
        dobPanel.setBounds(200,310,258,30);
        dobPanel.setBackground(new Color(63, 63, 62 ,100));
        JComboBox<String> dayBox = new JComboBox<>(new String[]{"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        JComboBox<String> monthBox = new JComboBox<>(new String[]{"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        JComboBox<String> yearBox = new JComboBox<>(new String[]{"","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"});
        dobPanel.add(dayBox);
        dobPanel.add(monthBox);
        dobPanel.add(yearBox);
        bgimage.add(dobPanel); //adding dobpanel to the rmpanel
        
        JLabel Mship = new JLabel("Membership Start Date:");
        Mship.setBounds(30,350,200,30);
        Mship.setFont(new Font("Arial",Font.BOLD,15));
        Mship.setForeground(Color.white);
        bgimage.add(Mship);
        
        JPanel MshipPanel = new JPanel();
        MshipPanel.setBounds(200,350,258,30);
        MshipPanel.setBackground(new Color(63, 63, 62 ,100));
        JComboBox<String> dayBox1 = new JComboBox<>(new String[]{"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        JComboBox<String> monthBox1 = new JComboBox<>(new String[]{"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        JComboBox<String> yearBox1 = new JComboBox<>(new String[]{"","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"});
        MshipPanel.add(dayBox1);
        MshipPanel.add(monthBox1);
        MshipPanel.add(yearBox1);
        bgimage.add(MshipPanel); //adding Mship panel to the rm panel
        
        //referal resources
        JLabel refResource = new JLabel("Referal Resources:");
        refResource.setBounds(500,70,150,30);
        refResource.setFont(new Font("Arial",Font.BOLD,15));
        refResource.setForeground(Color.white);
        bgimage.add(refResource);
        //referal resources textfield
        JTextField refResourceF = new JTextField();
        refResourceF.setBounds(660,70,200,30);
        bgimage.add(refResourceF);
        
        //Trainer name
        JLabel trainer = new JLabel("Trainer Name:");
        trainer.setBounds(500,110,150,30);
        trainer.setFont(new Font("Arial",Font.BOLD,15));
        trainer.setForeground(Color.white);
        bgimage.add(trainer);
        //referal resources textfield
        JTextField trainerF = new JTextField();
        trainerF.setBounds(660,110,200,30);
        bgimage.add(trainerF);
        
        //plan price
        JLabel plan=new JLabel("Plan Price: ");
        plan.setBounds(500,150,150,30);
        plan.setFont(new Font("Arial",Font.BOLD,15));
        plan.setForeground(Color.white);
        bgimage.add(plan);
        //planprice field
        JTextField planPriceF = new JTextField();
        planPriceF.setBounds(660,150,200,30);
        planPriceF.setEditable(false);
        planPriceF.setFocusable(false);
        planPriceF.setText("50000");
        bgimage.add(planPriceF);
        
        
        //paid amount
        JLabel paidAmount = new JLabel("Paid Amount:");
        paidAmount.setBounds(500,190,150,30);
        paidAmount.setFont(new Font("Arial",Font.BOLD,15));
        paidAmount.setForeground(Color.white);
        bgimage.add(paidAmount);
        //removal reason textfield
        JTextField paidAmountF = new JTextField();
        paidAmountF.setBounds(660,190,200,30);
        bgimage.add(paidAmountF);

        //add button
        JButton add = new JButton("Add");
        add.setBounds(30,430,100,40);
        add.setFont(new Font("Arial",Font.PLAIN,15));
        add.addActionListener (new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    if(idF.getText().isEmpty() || nameF.getText().isEmpty() ||locationF.getText().isEmpty() ||phoneF.getText().isEmpty() ||emailF.getText().isEmpty() ||refResourceF.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please fill the required fields.");
                        return;
                    }
                    //getting vlaues from inputfields
                    int id = Integer.parseInt(idF.getText());
                    String name = nameF.getText();
                    String location = locationF.getText();
                    String phone = phoneF.getText();
                    String email = emailF.getText();
                    String referralSource = refResourceF.getText();
                    
                    
                    //getting the dob
                    if(dayBox.getSelectedItem()==null||monthBox.getSelectedItem()==null||yearBox.getSelectedItem()==null){
                        JOptionPane.showMessageDialog(r,"Please select date of birth");
                        return;
                    }
                    //getting dob and start date 
                    String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
                    String startDate = dayBox1.getSelectedItem() + "-" + monthBox1.getSelectedItem() + "-" + yearBox1.getSelectedItem();
                    //gettig gender
                    String Gender = r1.isSelected() ? "Male" :"Female";
                    
                    //checking duplicate id
                    boolean dId = false;
                    for(GymMember m : memberList){
                        if(m.getId() == id){
                            dId = true;
                            break;
                        }
                    }
                    if(dId){
                        JOptionPane.showMessageDialog(r,"Member with this id already exist");
                        return;
                    }
                    
                    //creating regularmember object
                    PremiumMember newMember = new PremiumMember(id,  name,  location,  phone,  email, Gender, dob,  startDate,  referralSource);
                    
                    //add member to the memberlist
                    memberList.add(newMember);
                    
                    JOptionPane.showMessageDialog(r,"Member added successfully");
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(r,"Please enter a valid id");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(r,"An error occured" +ex.getMessage());
                }
                
            } 
            
        });
        bgimage.add(add);
        
        //Activate member button for premiumMember
        JButton Activate = new JButton("Activate Member");
        Activate.setBounds(190,430,190,40);
        Activate.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(Activate);
        Activate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to activate membership:");
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;

                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            member.activateMembership();
                            JOptionPane.showMessageDialog(null, "Membership activated for ID: " + id);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            }
        });
        
        //deactivate button for premium membership
        JButton deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to deactivate membership:");
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;
        
                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            member.deactivateMembership();
                            JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + id);
                            found = true;
                            break;
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            }
        });
        deactivateButton.setBounds(390,430,190,40);
        deactivateButton.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(deactivateButton);

        
        //markattendance button
        JButton PmarkAttendance = new JButton("Mark Attendance");
        PmarkAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to mark attendance:");
                
                try {
                    int id = Integer.parseInt(inputId);
                    boolean found = false;
        
                    for (GymMember member : memberList) {
                        if (member.getId() == id) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(null, "Attendance marked for Member ID: " + id);
                            found = true;
                            break;
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Member ID not found.");
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric ID.");
                }
            
            }
        });
        PmarkAttendance.setBounds(30,500,150,40);
        PmarkAttendance.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(PmarkAttendance);
        
        //clear button for premium member
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(500, 350, 100, 30);
        clearBtn.setFont(new Font("Arial",Font.PLAIN,15));
        bgimage.add(clearBtn);
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all JTextFields
                idF.setText("");
                nameF.setText("");
                locationF.setText("");
                phoneF.setText("");
                emailF.setText("");
                refResourceF.setText("");
                trainerF.setText("");
                planPriceF.setText("60000"); // reset to default value
                paidAmountF.setText("");
                //dueAmountF.setText(""); 
        
                // Clear radio buttons
                rg.clearSelection();
        
                // Reset combo boxes
                dayBox.setSelectedIndex(0);
                monthBox.setSelectedIndex(0);
                yearBox.setSelectedIndex(0);
        
                dayBox1.setSelectedIndex(0);
                monthBox1.setSelectedIndex(0);
                yearBox1.setSelectedIndex(0);
            }
        });


        //save to file premium
        JButton saveTofiles = new JButton("Save to File");
        saveTofiles.setBounds(190,500,150,40);
        saveTofiles.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(saveTofiles);
        saveTofiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("MemberDetails.txt", true))) {
                    String header = String.format(
                        "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Start Date", "Plan", "Price", "Attendance", "Loyalty",
                        "Status", "Full Payment", "Discount", "Paid"
                    );
                    writer.write("\n" + header);
        
                    for (GymMember member : memberList) {
                        if (member instanceof PremiumMember) {
                            PremiumMember p = (PremiumMember) member;
                            String status = p.getActiveStatus() ? "Active" : "Inactive";
                            String fullPay = p.getIsFullPayment() ? "Yes" : "No";
                            double netPaid = p.getPaidAmount() - p.getDiscountAmount();
        
                            String line = String.format(
                                "%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15d %-10s %-15s %-15.2d %-15.2d\n",
                                p.getId(), p.getName(), p.getLocation(), p.getPhone(), p.getEmail(),
                                p.getMembershipStartDate(), "Premium", p.getPremiumCharge(), p.getAttendance(),
                                p.getLoyaltyPoints(), status, fullPay, p.getDiscountAmount(), netPaid
                            );
                            writer.write(line);
                        }
                    }
        
                    JOptionPane.showMessageDialog(null, "Premium members saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving premium members: " + ex.getMessage());
                }
            }
        });
        
        //paydeu  button
        JButton payDue = new JButton("Pay Deu Amount");
        payDue.setBounds(350,500,150,40);
        payDue.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(payDue);
        payDue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Premium Member ID to Pay Due:", "Pay Due", JOptionPane.PLAIN_MESSAGE);
        
                if (inputId == null || inputId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Member ID is required.");
                    return;
                }
        
                boolean found = false;
        
                for (GymMember member : memberList) {
                    if (member instanceof PremiumMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
        
                        if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(null, "Member is not active. Cannot proceed with payment.");
                            return;
                        }
        
                        PremiumMember pm = (PremiumMember) member;
        
                        double remaining = pm.getPremiumCharge() - pm.getPaidAmount();
        
                        if (pm.getIsFullPayment()) {
                            JOptionPane.showMessageDialog(null, "Payment already completed.");
                            return;
                        }
        
                        String inputAmount = JOptionPane.showInputDialog(null,
                                "Remaining Amount: " + remaining + "\nEnter Amount to Pay:",
                                "Enter Payment", JOptionPane.PLAIN_MESSAGE);
        
                        if (inputAmount == null || inputAmount.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Payment amount is required.");
                            return;
                        }
        
                        try {
                            double amount = Double.parseDouble(inputAmount.trim());
                            String message = pm.payDueAmount(amount);
                            JOptionPane.showMessageDialog(null, message);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid amount entered.");
                        }
        
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Premium Member ID not found.");
                }
            }
        });


        //display button
        JButton display = new JButton("Display");
        display.setBounds(510,500,150,40);
        display.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(display);
        
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to Display:", "Search Member", JOptionPane.PLAIN_MESSAGE);
                
                // Cancel pressed or empty input
                if (inputId == null || inputId.trim().isEmpty()) {
                    return;
                }
        
                boolean found = false;
                JFrame displayData = new JFrame("Premium Member Info:");
                displayData.setSize(400, 500);
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
                StringBuilder txt = new StringBuilder();
        
                for (GymMember member : memberList) {
                    if (member instanceof PremiumMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
                        PremiumMember p = (PremiumMember) member;
        
                        txt.append("ID: ").append(p.getId()).append("\n");
                        txt.append("Name: ").append(p.getName()).append("\n");
                        txt.append("Email: ").append(p.getEmail()).append("\n");
                        txt.append("Phone: ").append(p.getPhone()).append("\n");
                        txt.append("Attendance: ").append(p.getAttendance()).append("\n");
                        txt.append("Status: ").append(p.getActiveStatus() ? "Active" : "Inactive").append("\n");
                        txt.append("Type: Premium Member\n");
                        txt.append("Price: ").append(p.getPremiumCharge()).append("\n");
                        txt.append("Paid Amount: ").append(p.getPaidAmount()).append("\n");
                        txt.append("Full Payment: ").append(p.getIsFullPayment()).append("\n");
        
                        displayArea.setText(txt.toString());
                        displayData.add(new JScrollPane(displayArea));
                        displayData.setVisible(true);
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No Premium Member found with ID: " + inputId, "Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        //revert Premium membership button
        JButton revertMS = new JButton("Revert MemberShip");
        revertMS.setBounds(670,500,150,40);
        revertMS.setFont(new Font("Arial",Font.PLAIN, 15));
        bgimage.add(revertMS);
        revertMS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Premium Member ID to Revert:", "Revert Premium Member", JOptionPane.PLAIN_MESSAGE);
        
                if (inputId == null || inputId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Member ID is required.");
                    return;
                }
        
                boolean found = false;
        
                for (GymMember member : memberList) {
                    if (member instanceof PremiumMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
                        PremiumMember pm = (PremiumMember) member;
                        pm.revertPremiumMember();
                        JOptionPane.showMessageDialog(null, "Premium Member reverted successfully.");
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No Premium Member found with ID: " + inputId);
                }
            }
        });
        
         //calculate discount amount   
        JButton calculateDiscount = new JButton("Discount amount: ");
        calculateDiscount.setBounds(590, 430, 200, 40);  // Adjust position as needed
        calculateDiscount.setFont(new Font("Arial", Font.PLAIN, 15));
        bgimage.add(calculateDiscount);
        calculateDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = JOptionPane.showInputDialog(null, "Enter Member ID to calculate discount:", "Discount Check", JOptionPane.PLAIN_MESSAGE);
        
                if (inputId == null || inputId.trim().isEmpty()) {
                    return; // Cancel or empty input
                }
        
                boolean found = false;
        
                for (GymMember member : memberList) {
                    if (member instanceof PremiumMember && String.valueOf(member.getId()).equals(inputId.trim())) {
                        found = true;
                        PremiumMember p = (PremiumMember) member;
        
                        if (p.getIsFullPayment()) {
                            p.calculateDiscount();  // Apply discount
                            JOptionPane.showMessageDialog(null, "Discount applied: " + p.getDiscountAmount(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Full payment not done. No discount available.", "No Discount", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No Premium Member found with ID: " + inputId, "Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        pm.setVisible(true);
        p.setVisible(true);
    }
    public static void main(String[] args){
        new GymGUI();
    }
}