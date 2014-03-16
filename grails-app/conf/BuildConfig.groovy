grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.dependency.resolver = 'maven'
grails.project.repos.default = "spireonSnap"

//grails.project.war.file = "target/${appName}-${appVersion}.war"


grails.project.fork = [
	/*
	// configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
	compile: [maxMemory: 1024, minMemory: 64, debug: false, maxPerm: 512, daemon:true],

	// configure settings for the test-app JVM, uses the daemon by default
	test: [maxMemory: 2048, minMemory: 1024, debug: false, maxPerm: 512, daemon:true],
	// configure settings for the run-app JVM
	run: [maxMemory: 2048, minMemory: 1024, debug: false, maxPerm: 512, forkReserve:false],
	// configure settings for the run-war JVM
	war: [maxMemory: 2048, minMemory: 1024, debug: false, maxPerm: 512, forkReserve:false],
	// configure settings for the Console UI JVM
	console: [maxMemory: 2048, minMemory: 64, debug: false, maxPerm: 256]
	*/
]

grails.project.dependency.resolution = {
	legacyResolve false
	// inherit Grails' default dependencies
	inherits("global") {
	}
	log "debug" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true
	repositories {
		inherits true
		grailsPlugins()
		grailsHome()
		grailsCentral()
		mavenLocal()
		mavenCentral()

		mavenRepo "http://repo.grails.org/grails/plugins" // backup grails repo
		mavenRepo "http://snapshots.repository.codehaus.org"
		mavenRepo "http://repository.codehaus.org"
		mavenRepo "http://download.java.net/maven/2/"
	}
	dependencies {
		//specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
	}
	plugins {
		runtime ":hibernate:3.6.10.10"
		runtime ":resources:1.1.6"
		// Uncomment these (or add new ones) to enable additional resources capabilities
		//runtime ":zipped-resources:1.0"
		//runtime ":cached-resources:1.0"
		//runtime ":yui-minify-resources:0.1.4"

		build ":tomcat:7.0.50.1"
		compile ":rest-client-builder:2.0.1"
		compile ":export:1.5"

		//
		// Including the following causes eventual StaleObjectExceptions in domains
		// not using the default datasource
		//
		if(System.getProperty('staleobject.usemongo')) {
			println "### USING MONGO ###"
			compile(":mongodb:1.3.3")
		}
	}
}

grails.project.plugins.dir="./plugins"
grails.tomcat.nio = true
