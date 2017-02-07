# dbpedia-chatbot_warmup
Repository for the warmup tasks mentioned on http://wiki.dbpedia.org/ideas/idea/282/first-chatbot-for-dbpedia/

This project is a Slack bot which receives messages on the channel, queries the WolframAlpha API, and displays the resulting pods and subpods as simple text messages on the channel.

### Getting started
To use this project, follow the steps given below:

1. Clone this project `$ git clone https://github.com/parthsuresh/alfred` and `$ cd alfred`
2. [Create a slack bot](https://my.slack.com/services/new/bot) and get your token.
3. Paste the token in [application.properties](/src/main/resources/application.properties) file.
4. Invite the bot to your channel.
5. [Create a wolfram alpha developer id] (http://products.wolframalpha.com/simple-api/documentation/), create an app and paste the app-id in [WolframAPI.java](/src/main/java/com/parthsuresh/alfred/WolframAPI/WolframAPI.java) file.
6. Install [Java binding for WolframAlphaAPI] (http://products.wolframalpha.com/api/libraries.html) into your local maven repository with groupID as 'com.wolfram', artifactID as 'WolframAlpha' and version as '1.1'. Click [here] (https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html) for instructions to do this.
7. Run the application by running `AlfredApplication` in your IDE or via commandline.
```
$ mvn spring-boot:run
```

### Images
![Image for search query : "Who won the Nobel Prize for physics in 1901?"]
(/images/NobelPrizeQuestion.png)

![Image for search query : "Who was Napoleon?"]
(/images/Napoleon.png)

![Image for search query : "What is 2*(10/5)*6 ?"]
(/images/MathematicalCalculation.png)

### Dependencies

1. [jbot] (https://github.com/ramswaroop/jbot/) by ramswaroop
2. [Java binding for WolframAlpha API] (http://products.wolframalpha.com/api/libraries.html) by Todd Gayley


PS : For the people who didn't get why this project is named so, Alfred is Bruce Wayne's(Batman's) butler. Big fan! :)
