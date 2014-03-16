# ========================================================
# Setup on a linux machine (e.g. RHEL 6.3)
# ========================================================
# setup a new sudoer user with all permissions
# switch to user. 
# create a setEnv file

#
# install git
#
sudo yum install git

# ========================================================
# Tools
# ========================================================

# install and test java
#
sudo yum install java-1.6.0-openjdk-devel.x86_64
javac -version
# run and add to the setEnv file
export JAVA_HOME=/usr/lib/jvm/jre-1.6.0-openjdk.x86_6
export PATH=$JAVA_HOME/bin:$PATH

#
# download, install and test groovy
#
cd Tools
wget http://dist.groovy.codehaus.org/distributions/groovy-binary-1.8.7.zip
unzip groovy-binary-1.8.7.zip 
# run and add to the setEnv file
export GROOVY_HOME=/home/gcomeau/Tools/groovy-1.8.7
export PATH=$PATH:$GROOVY_HOME/bin
groovysh

#
# download, install and test grails
#
cd Tools
wget http://dist.springframework.org.s3.amazonaws.com/release/GRAILS/grails-2.0.4.zip
unzip grails-2.0.4.zip
# run and add to the setEnv file
export GRAILS_HOME=/home/gcomeau/Tools/grails-2.0.4
export PATH=$PATH:$GRAILS_HOME/bin
grails

#
# git clone ssh://git@github.com/ProconGPS/ProconAdmin
#
cd ProconAdmin
./testApp
# will download a bunch of plugins.


# ========================================================
# Install the data stuff
# ========================================================

# add the yum repo, then
sudo yum install mongo-10gen mongo-10gen-server

# install mysql
sudo yum install mysql-server
sudo service mysqld start

# Add the test DB and creds
mysql> CREATE DATABASE proconCore_development;
mysql> CREATE USER 'procon'@'localhost' IDENTIFIED BY 'Pa55w0rd';
mysql> GRANT all ON proconCore_development.* to 'procon'@'localhost';


# Download and install redis
sudo yum install gcc

wget http://redis.googlecode.com/files/redis-2.4.17.tar.gz
gunzip redis-2.4.17.tar.gz 
untar redis-2.4.17.tar 
tar xvf redis-2.4.17.tar 
cd redis-2.4.17
sudo make
make test
cd src
./redis-server

# Download and install activemq
cd Tools
wget http://apache.skazkaforyou.com/activemq/apache-activemq/5.6.0/apache-activemq-5.6.0-bin.tar.gz
gunzip apache-activemq-5.6.0-bin.tar.gz 
tar xvf apache-activemq-5.6.0-bin.tar 
find apache-activemq-5.6.0
cd apache-activemq-5.6.0

# start activemq
cd bin/
./activemq status
./activemq start
./activemq status




