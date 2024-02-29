
*****************************************************PROJECT DESCRIPTION*****************************************************************
 
Problem Statement : Display Bookshelves

1.Login into Urbanladder

2.Search for bookshelves

3.Filter bookshelves

4.Print information related to filtered bookshelves

5.Verify Living submenu items

6.Go to Gift Card link

7.Fill invalid form and capture error

8.Fill valid form and verify
 
Detailed description: Main Project
 
 
1.Navigate to urbanladder.com

2.Verify navigation to site

3.Verify if searchbar is present or not

4.Search for bookshelves

5.Verify navigation to search page

6.Apply filters basaed on sorting, price, category

7.Print brand and price details of filtered search result

8.Verify if Living menu is present or not

9.Verify if submenus are present under Living menu or not

10.Print all the submenu items 

11.Verify if Gift Card link is present or not

12.Click on Gift Card link

13.Verify navigation to gift card page

13.Verify if Birthday option is present or not

14.Choose Birthday option

15.Fill gift information

16.Fill invalid form details

17.Print error message

18.Fill valid form details

19.Verify the given details
 
 
**********************************************************STEPS TO EXECUTE*************************************************************
 
-unzip the folder

-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location unzip the folder-> click on finish

-Now go to the testng.xml file and run.

-Now the file will Execute and we get the expected output as shown below.
 
*******************************************************FILES DESCRIPTION**************************************************************
 
1. src/test/java: There are four packages in this folder- page object,testBase,testCases and utilities.

pageObject contains the page object files, testBase contains the java file BaseClass which has reusable functions that are used often in the project,
testCases contains all the different test case java files and utilities contains the ExtentReport Manager class and the Excel Utilities class .
 
2.src/test/resources: It contains the property file which has different variables
 
3.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,

Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.
 
3.testData: In this folder we have .xlsx files for reading and writing.
  
4.screenshots: This folder stores the result screenshot.
  
5. test-output: This folder contains automatically genereated testNG reports.
 
6.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,

build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

7.testng.xml:It is the configuration file which is used to handle test cases

8.grouping.xml: This configuration file handles the sanity and regression test case groups

