# move-joomla-to-wp

The application migrates Joomla 3.x content to Wordpress. 

## Structure

The application uses Spring Boot. It consist of a classic DAO layer with a Service layer to extract content from Joomla database structure and insert data to WordPress data repository. Services are called by Spring Boot main class. 

## Buidling

Gradle is used as a build tool

## Data

For running the integration tests and executing the migration, two docker mysql images are used - one with the dump of the source system and one with "basic" configuration of WordPress database.

