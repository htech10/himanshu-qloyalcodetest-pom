# himanshu-qloyalcodetest-pom

# How to run the project
1. Clone the repository 

git clone https://github.com/htech10/himanshu-qloyalcodetest-pom.git

2. you will have downloaded a folder "himanshu-qloyalcodetest-pom" after above command and this is your maven project

3. Import this project using eclipse

3.1 From Eclipse goto File > Import and choose existing Maven Project under Maven

3.2 Browse through the folder you just downloaded from github and make it root in the window

3.3 It will automatically reflect pom.xml if you have chosen it correctly. 

3.4 On the same window click on 'Add project(s) to working set'

3.5 click finish, now on the left panel you should see the folder

3.6 Right click on the root folder > go to Maven > Update Project

4. Goto 'src/test/java' > 'tests' and right click on TourBookingTest.java and run as TestNG test/java


   Important: If you do not get option to run as TestNG test, check if TestNG plugin is added to the Eclipse
   Go to Help > Eclipse MarketPlace > Search for TestNG and Install it 


### Note: This is not a framework, it just showcases a general way of code organisation using page object model.Code will have to be refactored many times to make DRY styled code and logging reporting and BDD integration, tagging is still to be done. 

# To run the cross browser testing using docker Grid, setup the grid as follows :
(Note: Following Instructions are only verified on docker toolbox for Windows but apart of installation, commands to setup grid would be same)

1. download docker toolbox and follow the installation https://docs.docker.com/toolbox/toolbox_install_windows/

2. Pull the Selenium hub from docker repository using following command:

$ docker pull selenium/hub

3. Run the Hub to assign the port using below command:

$ docker run -d -p 8888:4444 --name selenium-hub selenium/hub

-d means detached. If you specify this parameter then the container will run at the background as a daemon.
-p means map a local(physical host machine) port to the container port.
-p 8888:4444 means you can use http://docker_machine_ip:8888/grid/console to access the container’s web console

Checkout the console in something like For eg, http://192.168.99.100:8888/grid/console
IP of your docker would be at the top of the screen

4. Run the following command to find out list of all containers and respective status
$ docker ps -a

5. Setup Nodes (Chrome and Firefox)

5.1 pull the nodes
$ docker pull selenium/node-chrome
$ docker pull selenium/node-firefox

5.2 link the nodes to the hub
$ docker run -d --link selenium-hub:hub selenium/node-chrome
$ docker run -d --link selenium-hub:hub selenium/node-firefox

5.3 check the nodes using 
docker ps -a 
- there should be three items (1 hub and 2 nodes) visible

6. To restart the process , and shutdown grid infrastructure
$ docker stop $(docker ps -a -q)
$ docker rm $(docker ps -a -q)

Once setup, grid would be ready for use.

# In this current shape, execution of docker grid is failing which needs to debugged further to make it run smoothely
	

