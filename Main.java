

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//	objects Backend
	PeopleBag pBag = new PeopleBag();
	CourseBag cBag = new CourseBag();
	TextBookBag tBag = new TextBookBag();
	
    //root intilization
        StackPane root1 = new StackPane();
        StackPane root2 = new StackPane();
        StackPane root3 = new StackPane();
    // window    
        Stage window;
        
    //scenes
        Scene mainScene = new Scene(root1, 500, 600);
        Scene scene2 = new Scene(root2,500,600);
        Scene scene3 = new Scene(root3,500,600);
    @Override
    
    
    public void start(Stage primaryStage) {
        
        
        // window stage
          window = primaryStage;
        
        //Home Screen Buttons
        
        Button finderButton = new Button();
            finderButton.setText("Finder");
        Button adderButton = new Button();
            adderButton.setText("Adder");
        Button deleteButton = new Button("Delete");
        Button viewerButton = new Button();
            viewerButton.setText("Viewer");
        Button saveButton = new Button();
            saveButton.setText("save");
        Button loadButton = new Button();
            loadButton.setText("load");
        
        ////////////////// finder Button /////////////////////////////////
        Button idButton = new Button();
            idButton.setText("ID");
        Button idSubmitButton = new Button();
            idSubmitButton.setText("Submit");
        Button isbnButton = new Button();
            isbnButton.setText("ISBN");
        Button isbnSubmitButton = new Button();
            isbnSubmitButton.setText("Submit");
        Button isbnReturnButton = new Button();
            isbnReturnButton.setText("Return");
        Button crnButton = new Button();
            crnButton.setText("CRN");
        Button crnSubmitButton = new Button();
            crnSubmitButton.setText("Submit");
        Button crnReturnButton = new Button();
            crnReturnButton.setText("Return");
        Button finderReturnButton = new Button();
            finderReturnButton.setText("Return");
        Button idReturnButton = new Button();
            idReturnButton.setText("Return");
        
        // Adder Buttons
        
        Button personButton = new Button();
            personButton.setText("Person");
        Button studentButton = new Button();
            studentButton.setText("Student");
        Button facultyButton = new Button();
            facultyButton.setText("Faculty");
        Button textBookButton = new Button();
            textBookButton.setText("TextBook");
        Button courseButton = new Button();
            courseButton.setText("Course");
        Button adderReturnButton = new Button();
            adderReturnButton.setText("Return");
            
        // Viewer Buttons
            
        Button personListButton = new Button();
            personListButton.setText("PersonList");
        Button studentListButton = new Button();
            studentListButton.setText("StudentList");
        Button facultyListButton = new Button();
            facultyListButton.setText("FacultyList");
        Button textBookListButton = new Button();
            textBookListButton.setText("TextBookList");
        Button courseListButton = new Button();
            courseListButton.setText("CourseList");
        Button viewerReturnButton = new Button();
            viewerReturnButton.setText("Return");
            
        ///////////////////// Main Action events ///////////////////////////////////////
            
        //	Delete Button Action
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		
        		Button deleteReturnButton = new Button("Return");
        		Button idDeleteButton = new Button ("ID");
        		Button isbnDeleteButton = new Button ("ISBN");
        		Button crnDeleteButton = new Button("CRN");
        		HBox deleteHBox = new HBox(idDeleteButton,isbnDeleteButton, crnDeleteButton, deleteReturnButton);
        		root2.getChildren().clear();
        		root2.getChildren().add(deleteHBox);
        		window.setScene(scene2);
        		
        		//	ID Delete Button
        		idDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent arg0) {
						TextField id = new TextField("Enter ID");
						Button submitDeleteButton = new Button("Submit");
						Button returnDeleteButton = new Button("Return");
						VBox deleteVBox = new VBox(id, submitDeleteButton, returnDeleteButton);
						root3.getChildren().clear();
						root3.getChildren().add(deleteVBox);
						window.setScene(scene3);
						
						returnDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								root3.getChildren().clear();
								window.setScene(scene2);
							}
						});
						
						//	DELETE BY ID
						submitDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								Label label = new Label("Incorrect Format: "+id.getText().trim());
								try {
									Integer tempInt = Integer.parseInt(id.getText());
									if (pBag.delete(tempInt))
										label = new Label("Deleted: "+tempInt);
									else 
										label = new Label("Does NOT Exist: "+tempInt);
									deleteVBox.getChildren().add(label);
								} catch (Exception e) {deleteVBox.getChildren().add(label);}
								
							}
						});
					}
        			
        		});
        		
        		//	ISBN DELETE BUTTON
        		isbnDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent arg0) {
						TextField isbn = new TextField("Enter ISBN");
						Button submitDeleteButton = new Button("Submit");
						Button returnDeleteButton = new Button("Return");
						VBox deleteVBox = new VBox(isbn, submitDeleteButton, returnDeleteButton);
						root3.getChildren().clear();
						root3.getChildren().add(deleteVBox);
						window.setScene(scene3);
						
						returnDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								root3.getChildren().clear();
								window.setScene(scene2);
							}
						});
						
						//	DELETE BY ISBN
						submitDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								Label label = new Label("Incorrect Format: "+isbn.getText().trim());
								try {
									Integer tempInt = Integer.parseInt(isbn.getText());
									if (tBag.delete(tempInt))
										label = new Label("Deleted: "+tempInt);
									else 
										label = new Label("Does NOT Exist: "+tempInt);
									deleteVBox.getChildren().add(label);
								} catch (Exception e) {deleteVBox.getChildren().add(label);}
								
							}
						});
					}
        			
        		});
        		
        		//	CRN DELETE BUTTON
        		crnDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent arg0) {
						TextField crn = new TextField("Enter CRN");
						Button submitDeleteButton = new Button("Submit");
						Button returnDeleteButton = new Button("Return");
						VBox deleteVBox = new VBox(crn, submitDeleteButton, returnDeleteButton);
						root3.getChildren().clear();
						root3.getChildren().add(deleteVBox);
						window.setScene(scene3);
						
						returnDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								root3.getChildren().clear();
								window.setScene(scene2);
							}
						});
						
						//	DELETE BY ISBN
						submitDeleteButton.setOnAction(new EventHandler<ActionEvent>(){
							public void handle(ActionEvent arg0) {
								Label label = new Label("Incorrect Format: "+crn.getText().trim());
								try {
									Integer tempInt = Integer.parseInt(crn.getText());
									if (cBag.delete(tempInt))
										label = new Label("Deleted: "+tempInt);
									else 
										label = new Label("Does NOT Exist: "+tempInt);
									deleteVBox.getChildren().add(label);
								} catch (Exception e) {deleteVBox.getChildren().add(label);}
								
							}
						});
					}
        			
        		});
        		
        		deleteReturnButton.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent arg0) {
						root2.getChildren().clear();
						window.setScene(mainScene);
					}
				});
        	};
        });

        ///////////////////////// finder Action Events///////////////////////////////////////////
        finderButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                HBox finderButtons = new HBox(idButton,isbnButton,crnButton,finderReturnButton);
                root2.getChildren().clear();
                root2.getChildren().add(finderButtons);
                window.setScene(scene2);
                
        
        //	ID BUTTONS
        idButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {    
                TextField idField = new TextField();
                idField.setPromptText("Enter ID");
                VBox idBox = new VBox(idField,idSubmitButton,idReturnButton);
                idBox.setSpacing(2);
                root3.getChildren().clear();
                root3.getChildren().add(idBox);
                window.setScene(scene3);
                
                idSubmitButton.setOnAction(new EventHandler<ActionEvent>() {  //////////////IdButton
           		 public void handle(ActionEvent event) { 
           			Label result;
           			try {
           				int idNum = Integer.parseInt(idField.getText());
           				if (pBag.find(idNum) != null)
           					result = new Label(pBag.find(idNum).toString());
           				else
           					result = new Label("Not Found!");
           			} catch (Exception e) { result = new Label("Incorrect Format (search by ID)");}
           			idBox.getChildren().add(result);
                    
           		 }});
            }});
        
        //	ID return
        idReturnButton.setOnAction(new EventHandler<ActionEvent>() {  //////////////IdButton
            @Override
            public void handle(ActionEvent event) { 
                root3.getChildren().clear();
                window.setScene(scene2);
            }});
        
       //ISBN BUTTONS
        isbnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField isbnField = new TextField();
                isbnField.setPromptText("Enter ISBN");
                VBox isbnBox = new VBox(isbnField,isbnSubmitButton,isbnReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(isbnBox);
                window.setScene(scene3);
                
                isbnSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) { 
                    	Label result;
               			try {
               				int idNum = Integer.parseInt(isbnField.getText());
               				if (tBag.find(idNum) != null)
               					result = new Label(tBag.find(idNum).toString());
               				else
               					result = new Label("Not Found!");
               			} catch (Exception e) { result = new Label("Incorrect Format (search by ID)");}
               			isbnBox.getChildren().add(result);  
                }});
            }});
        
        // ISBN return
        isbnReturnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {  
            	
                root3.getChildren().clear();
                window.setScene(scene2);
            }});
        
        //CRN BUTTONS
        crnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextField crnField = new TextField();
                crnField.setPromptText("Enter ISBN");
                VBox crnBox = new VBox(crnField,crnSubmitButton,crnReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(crnBox);
                window.setScene(scene3);
                
                crnSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) { 
                    	Label result;
               			try {
               				int idNum = Integer.parseInt(crnField.getText());
               				if (cBag.find(idNum) != null)
               					result = new Label(cBag.find(idNum).toString());
               				else
               					result = new Label("Not Found!");
               			} catch (Exception e) { result = new Label("Incorrect Format (search by ID)");}
               			crnBox.getChildren().add(result);
                }});
            }});    
        // CRN return
        crnReturnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {  ///////////////////////isbnButton
                root3.getChildren().clear();
                window.setScene(scene2);
            }});        
   
        ////////////////////////finderReturnButton////////////////////////////////        
            
        finderReturnButton.setOnAction(new EventHandler<ActionEvent>() {    
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
      
            
            }
        });
        //adder Button
        adderButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root2.getChildren().clear();
                HBox adderButtons = new HBox(personButton,studentButton,facultyButton,textBookButton,courseButton,adderReturnButton);
                root2.getChildren().add(adderButtons);
                window.setScene(scene2);
            }
        });
        //viewer button
        viewerButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                root2.getChildren().clear();
                HBox viewerButtons = new HBox(personListButton,studentListButton,facultyListButton,textBookListButton,courseListButton,viewerReturnButton);
                root2.getChildren().add(viewerButtons);
                window.setScene(scene2);
               
            }
        });
        //save button
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Bag b = new Bag(pBag,cBag,tBag);
                try {
					b.save("Bag_Data.sr");
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        //load button
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Bag b = new Bag(pBag,cBag,tBag);
                try {
					b.load("Bag_Data.sr");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                pBag = b.getpBag();
                cBag = b.getcBag();
                tBag = b.gettBag();
            }
        });
        
        
        ///////////////////////////Scene 2 Action Events//////////////////////////////////////////
        
        
        
        
        /////////////////////////////////Adder Action Buttons///////////////////////////////////
        Button personSubmitButton = new Button();
        Button personReturnButton = new Button();
        personButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Person(String fName, String lName, Integer id, Integer phone, String home)
      
            	personSubmitButton.setText("Submit");
                personReturnButton.setText("Return");
                TextField fName = new TextField();
                TextField lName = new TextField();
                TextField id = new TextField();
                TextField phone = new TextField();
                TextField home = new TextField();
                fName.setPromptText("First Name");
                lName.setPromptText("Last Name");
                id.setPromptText("ID");
                phone.setPromptText("Phone Number");
                home.setPromptText("Home Address");
                VBox personBox = new VBox(fName, lName, id, phone, home, personSubmitButton,personReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(personBox);
                window.setScene(scene3);
                
             // Add Person Submit Button
                personSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {
                		String first = fName.getText().trim();
                		String last = lName.getText().trim();
                		String homeAdd = home.getText().trim();
                		Integer idNum, phoneNum;
                		try {
                			idNum = Integer.parseInt(id.getText());
                		} catch (Exception e) {idNum = null;}
                		try {
                			phoneNum = Integer.parseInt(phone.getText());
                		} catch (Exception e) {phoneNum = null;}
                		if ( pBag.find(idNum) == null) {
                			Person person = new Person (first, last, idNum, phoneNum, homeAdd);
                			pBag.add(person);
                			root3.getChildren().clear();
                            window.setScene(scene2);
                		}
                		else {
                			Label notFound = new Label("ID already exists. Pick a different ID");
                			root3.getChildren().add(notFound);
                		}
                }});
            
            }}); 
         
        // Person Return Button
        
        
        personReturnButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                        root3.getChildren().clear();
                        window.setScene(scene2);
                
        }});
    
        
        /////////////////////////////////////////Student Action button////////////////////////////////////
        Button studentSubmitButton = new Button();
        Button studentReturnButton = new Button();
        studentButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                studentReturnButton.setText("Return");
            	studentSubmitButton.setText("Submit");
                TextField fName = new TextField();
                TextField lName = new TextField();
                TextField id = new TextField();
                TextField phone = new TextField();
                TextField home = new TextField();
                TextField gpa = new TextField();
                TextField major = new TextField();
                TextField courses = new TextField();
                TextField inProgress = new TextField();
                TextField remaining = new TextField();
                TextField credits = new TextField();
                fName.setPromptText("First Name");
                lName.setPromptText("Last Name");
                id.setPromptText("ID");
                phone.setPromptText("Phone Number");
                home.setPromptText("Home Address");
                gpa.setPromptText("GPA");
                major.setPromptText("Major");
                courses.setPromptText("Courses Taken (Enter CRN seperated by comma)");
                inProgress.setPromptText(" CoursesInprogress (Enter CRN seperated by comma)");
                remaining.setPromptText("CoursesRemaining (Enter CRN seperated by comma)" );
                credits.setPromptText("Enter Credits");
                
                VBox studentBox = new VBox(fName, lName, id, phone, home,gpa,major,courses,inProgress,remaining,credits, studentSubmitButton,studentReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(studentBox);
                window.setScene(scene3);
                
                // Student Submit Button
                studentSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {
                        // Student(String fName, String lName, Integer id, Integer phone, String home)   
                		String first = fName.getText().trim();
                		String last = lName.getText().trim();
                		String homeAdd = home.getText().trim();
                		String majorNum = major.getText().trim();
                		Integer idNum, phoneNum, creditsNum;
                		Double gpaNum;
                		List<Courses> takenStr = new ArrayList<>();
                		List<Courses> inProgressStr = new ArrayList<>();
                		List<Courses> remainingStr = new ArrayList<>();
                		
                		String[] tempStr;
                		Integer[] tempInt;
                		int sizeOfTempStr;
                		Label label;
                		//	Courses Taken String into Integer
                		tempStr = courses.getText().split(",");
                		sizeOfTempStr = tempStr.length;
                		tempInt = new Integer[sizeOfTempStr];
                		for (int i=0;i<sizeOfTempStr; i++){
                			try {
                				tempInt[i] = Integer.parseInt(tempStr[i]);
                				if (cBag.find(tempInt[i]) != null) {
                					takenStr.add(cBag.find(tempInt[i]));
                					label = new Label (tempInt[i] + " Found and added.");
                				}
                				else 
                					label = new Label(tempInt[i] + " course does not exist!");
                				studentBox.getChildren().add(label);
                			} catch (Exception e) {studentBox.getChildren().add(new Label("Could not parse " + tempStr[i]));}
                		}
                		
                		//   Courses inProgress String into Integer
                		tempStr = inProgress.getText().split(",");
                		sizeOfTempStr = tempStr.length;
                		tempInt = new Integer[sizeOfTempStr];
                		for (int i=0;i<sizeOfTempStr; i++){
                			try {
                				tempInt[i] = Integer.parseInt(tempStr[i]);
                				if (cBag.find(tempInt[i]) != null) {
                					inProgressStr.add(cBag.find(tempInt[i]));
                					label = new Label (tempInt[i] + " Found and added.");
                				}
                				else 
                					label = new Label(tempInt[i] + " course does not exist!");
                				studentBox.getChildren().add(label);
                			} catch (Exception e) {studentBox.getChildren().add(new Label("Could not parse " + tempStr[i]));}
                		}
                		
                	//   Courses remaining String into Integer
                		tempStr = remaining.getText().split(",");
                		sizeOfTempStr = tempStr.length;
                		tempInt = new Integer[sizeOfTempStr];
                		
                		for (int i=0;i<sizeOfTempStr; i++){
                			try {
                				tempInt[i] = Integer.parseInt(tempStr[i]);
                				if (cBag.find(tempInt[i]) != null) {
                					remainingStr.add(cBag.find(tempInt[i]));
                					label = new Label (tempInt[i] + " Found and added.");
                				}
                				else 
                					label = new Label(tempInt[i] + " course does not exist!");
                				
                				studentBox.getChildren().add(label);

                			} catch (Exception e) {studentBox.getChildren().add(new Label("Could not parse " + tempStr[i]));}
                		}
                		
                		try {
                			idNum = Integer.parseInt(id.getText());
                		} catch (Exception e) {idNum = null;}
                		try {
                			phoneNum = Integer.parseInt(phone.getText());
                		} catch (Exception e) {phoneNum = null;}
                		try {
                			creditsNum = Integer.parseInt(credits.getText());
                		} catch (Exception e) {creditsNum = null;}
                		try {
                			gpaNum = Double.parseDouble(gpa.getText());
                		} catch (Exception e) {gpaNum = null;}
                		
                		Student student = new Student (first, last, idNum, phoneNum, homeAdd);
                		student.setCourses(takenStr);
                		student.setInProgress(inProgressStr);
                		student.setRemaining(remainingStr);
                		pBag.add(student);
                		//window.setScene(scene2);
                }});
            
            }}); 
        
     
        
       // student return Button  
        studentReturnButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event){
                    root3.getChildren().clear();
                    window.setScene(scene2);
                }});
        
        ////////////////////////////////FacultyButton Action/////////////////////////
        Button facultySubmitButton = new Button();
        Button facultyReturnButton = new Button();
        
        facultyButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {    
            	facultySubmitButton.setText("Submit");
                facultyReturnButton.setText("Return");
                TextField fName = new TextField();
                TextField lName = new TextField();
                TextField id = new TextField();
                TextField phone = new TextField();
                TextField home = new TextField();
                TextField officeAdd = new TextField();
                TextField title = new TextField();
                TextField department = new TextField();
                TextField payScale = new TextField();
                
                fName.setPromptText("First Name");
                lName.setPromptText("Last Name");
                id.setPromptText("ID");
                phone.setPromptText("Phone Number");
                home.setPromptText("Home Address");
                officeAdd.setPromptText("OfficeAdd");
                title.setPromptText("Title");
                department.setPromptText("Department");
                payScale.setPromptText("PayScale(1~12)");
                VBox facultyBox = new VBox(fName, lName, id, phone, home,officeAdd,title,department,payScale, facultySubmitButton,facultyReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(facultyBox);
                window.setScene(scene3);
                
                // Faculty Submit Button
                facultySubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {
                		
                	String firstStr = fName.getText().trim();
                	String lastStr = lName.getText().trim();
                	String idStr = id.getText();
                	String phoneStr = phone.getText();
                	String homeStr = home.getText().trim();
                	String payScaleStr = payScale.getText();
                	Integer idNum, phoneNum, payScaleNum;
                	try {
                		idNum = Integer.parseInt(idStr);
                	} catch (Exception e) {idNum = null;}
                	try {
                		phoneNum = Integer.parseInt(phoneStr);
                	} catch (Exception e) {phoneNum = null;}
                	try {
                		payScaleNum = Integer.parseInt(payScaleStr);
                	} catch (Exception e) {payScaleNum = 0;}
                	
                	Faculty faculty = new Faculty(firstStr,lastStr,idNum,phoneNum,homeStr);
                	faculty.setDepartment(department.getText().trim());
                	faculty.setOfficeAdd(officeAdd.getText().trim());
                	faculty.setPayScale(payScaleNum);
                	faculty.setTitle(title.getText().trim());
                	pBag.add(faculty);
                	root3.getChildren().clear();
                	window.setScene(scene2);
                }});  
            }});
    
    
        facultyReturnButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
                    root3.getChildren().clear();
                    window.setScene(scene2);
        }});
        ///////////////////////////TextBook Button Action//////////////////////////////////
       Button textBookSubmitButton = new Button();
       Button textBookReturnButton = new Button();
       
       textBookButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               
            	textBookSubmitButton.setText("Submit");
                textBookReturnButton.setText("Return");
                TextField title = new TextField();
                TextField author = new TextField();
                TextField publisher = new TextField();
                TextField price = new TextField();
                TextField isbn = new TextField();
                TextField year = new TextField();
                title.setPromptText("Title");
                author.setPromptText("Author");
                publisher.setPromptText("Publisher");
                price.setPromptText("Price");
                isbn.setPromptText("ISBN");
                year.setPromptText("Year");
                VBox textBookBox = new VBox(title,author,publisher,price,isbn,year, textBookSubmitButton,textBookReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(textBookBox);
                window.setScene(scene3);
                
                textBookSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {
                		String titleStr = title.getText().trim();
                		String authorStr = author.getText().trim();
                		String publisherStr = publisher.getText().trim();
                		String priceStr = price.getText().trim();
                		String isbnStr = isbn.getText().trim();
                		String yearStr = year.getText().trim();
                		Double priceDub;
                		Integer isbnNum, yearNum;
                		try {
                			priceDub = Double.parseDouble(priceStr);
                		} catch (Exception e) {priceDub = null;}
                		try {
                			isbnNum = Integer.parseInt(isbnStr);
                		} catch (Exception e) {isbnNum = null;}
                		try {
                			yearNum = Integer.parseInt(yearStr);
                		} catch (Exception e) {yearNum = null;}
                		
                		TextBook book = new TextBook(titleStr,authorStr, publisherStr, priceDub, isbnNum, yearNum);
                		tBag.add(book);
                		window.setScene(scene2);
                }});
            
            }}); 
 
        textBookReturnButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        	    root3.getChildren().clear();
                    window.setScene(scene2);
        }});
        
    /////////////////////////////////////Course Button Action///////////////////////////////////////////////    
       Button courseSubmitButton = new Button();
       Button courseReturnButton = new Button();
       
        courseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
            	courseSubmitButton.setText("Submit");
                courseReturnButton.setText("Return");
                TextField title = new TextField();
                TextField number = new TextField();
                TextField crn = new TextField();
                TextField textBook = new TextField();
                TextField faculty = new TextField();
                TextField credits = new TextField();
                TextField roster = new TextField();
                TextField classRoom = new TextField();
                
                title.setPromptText("Title");
                number.setPromptText("Course Number");
                crn.setPromptText("CRN");
                textBook.setPromptText("Text Book");
                faculty.setPromptText("Faculty");
                credits.setPromptText("Credits");
                roster.setPromptText("Roster");
                classRoom.setPromptText("Classroom");
                VBox courseBox = new VBox(title,number,crn,textBook,faculty,credits,roster,classRoom,courseSubmitButton,courseReturnButton);
                root3.getChildren().clear();
                root3.getChildren().add(courseBox);
                window.setScene(scene3);
                
             // Course Submit Button
                courseSubmitButton.setOnAction(new EventHandler<ActionEvent>() {
                	public void handle(ActionEvent event) {
                		String titleStr = title.getText().trim();
                		String numberStr = number.getText().trim();
                		String crnStr = crn.getText().trim();
                		String textBookISBNStr = textBook.getText().trim();
                		String facultyStr = faculty.getText().trim();
                		String creditsStr = credits.getText().trim();
                		String classRoomStr = classRoom.getText().trim();
                		Integer crnNum, creditsNum, textBookISBNNum;
                		
                		//	Roster parse From string to integer
                		List<Student> students = new ArrayList<>();
						if (!(roster.getText() == null || roster.getText().equals(""))) {
							String[] rosterStrArr = roster.getText().split(",");
							Integer[] rosterIntArr = new Integer[rosterStrArr.length];
							for (int i = 0; i < rosterStrArr.length; i++) {
								try {
									rosterIntArr[i] = Integer
											.parseInt(rosterStrArr[i]);
								} catch (Exception e) {
									Label incorrectRoster = new Label(
											"Incorrect roster format");
									root3.getChildren().add(incorrectRoster);
								}
							}
	                		for (Integer i: rosterIntArr)
	                			students.add(pBag.find(i));
						}

                		try {
                			crnNum = Integer.parseInt(crnStr);
                		} catch (Exception e) {crnNum = null;}
                		try {
                			creditsNum = Integer.parseInt(creditsStr);
                		} catch (Exception e) {creditsNum = null;}
                		
                		TextBook book = null;
                		try {
                			textBookISBNNum = Integer.parseInt(textBookISBNStr);
                			if (tBag.find(textBookISBNNum) != null) 
                				book = tBag.find(textBookISBNNum);
                			else
                				book = null;
                
                		} catch (Exception e) {textBookISBNNum = null;}
                		
                		Faculty faculty = null;
                		try {
                			Integer facultyNum = Integer.parseInt(facultyStr);
                			if (pBag.find(facultyNum) != null)
                				faculty = pBag.find(facultyNum);
                			else
                				faculty = null;
                		} catch (Exception e) {}
                		
                		
                		
                		//public Courses(String title, String room, Integer number, Integer cRN,
            			//Integer credits, TextBook textBook, Faculty faculty,
            			//List<Student> roster)
                		
                		Courses course = new Courses(titleStr, classRoomStr, numberStr, crnNum, creditsNum,book, faculty, students);
                		cBag.add(course);
                		window.setScene(scene2);
                }});
            
            }}); 
        
        courseReturnButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
                    root3.getChildren().clear();
                    window.setScene(scene2);
        }});
        
        
        //////////////////////////AdderReturn Action////////////////////////////
        adderReturnButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               root2.getChildren().clear();
               window.setScene(mainScene);
            }});
        
            
    /////////////////////////////////////Viewer Action Buttons//////////////////////////////
            
            
        personListButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
        studentListButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
        facultyListButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
        textBookListButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
        viewerReturnButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               window.setScene(mainScene);
            }});
             
             
        
        
        
        
        
       //main Buttons
        
        HBox mainButtons = new HBox(finderButton,adderButton,deleteButton, viewerButton,saveButton,loadButton);
        root1.getChildren().add(mainButtons);
        
        
       //scenes 
        
       // stage control        
        primaryStage.setTitle("Database");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
