
# dadata_integration_service

It's an integration service to dadata.ru. Allows to translate a textual address into coordinates.  
Deploys to *localhost:8010*

- Request URL example:

    http://localhost:8010/searchAddress?inputAddress={addressString}

{addressString} - is what you want to translate into coordinates

- Response example with addressString *"спб невский 17"*:

    {"latitude":59.9358319,"longitude":30.32086}

- How to run:

`$ java -jar dadata_integration_service.jar`

[Download JAR file](https://drive.google.com/file/d/1jjNBhAEu3afpfppIZRNxAbPnQQ98fZ-3/view?usp=sharing "Download JAR file")

Due to paid requests logs with current balance are showed in a console.  
Current balance 7.2RUB. Price for 1 request - 0.1RUB


