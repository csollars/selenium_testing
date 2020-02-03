# selenium_testing

How to run the test:
1) User will need JDK and Eclipse for java developers
2) User will need TestNG, which can be installed from the eclipse marketplace
	If TestNG is not in eclipse marketplace, you can download it from http://beust.com/eclipse
		1) In eclipse, click Help > Install New Software
		2) Enter "http://beust.com/eclipse" in the 'Work with:' field
		3) Click the checkbox next to TestNG
		4) Click Next and install the default packages
3) Import Git project from https://github.com/riis/CultureConnectTests.git
4) Create run configuration for the test you wish to run
	1) Right-Click on the xml name, in the package explorer, for the test you wish to run. (src>xml>xmlName.xml)
	2) Click Run As > Run Configurations
	3) Right-Click on TestNG in the left-side panel.
	4) Click on New Configuration.
	5) Name the configuration the same name as the test you are going to run (ex: CCQ_Updates)
	6) Click the Suite radio button.
	7) Click the Browse button and select the xml from your file explorer.
		C:\Users\yourUserName\git\CultureConnectTests\selenium\src\xml\CCQ_Updates.xml
	8) Click Apply, then Close.
	9) Press the Run button in Eclipse to start the test.
	
Edit the parameter values on the xml to test with different browsers, testing environments, login credentials, etc.
	
****************************** If you wish to test on Edge browser ******************************
	Microsoft WebDriver, used to drive Edge browser, is now included in Windows 10.
	You must enable the feature in Windows.
	Go to Start > Settings > Apps > Manage Optional Features > Add a Feature > Microsoft Web Driver
****************************************************************************************************