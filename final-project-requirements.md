# Project

## Airports

### Overview

We need an application which allows us to manage information about commercial flights.

### Concepts we use

- airports
- airlines
- flights

### Requirements

#### General requirements

- every page in the application will have the same layout: header, content, footer
- the header and footer are defined once and included in every page using the technique we learned
- the application will respond with a custom error page when the user tries to access a page which doesn't exist (HTTP response code 404)
- for any other error, the application responds with a general purpose error page (see https://www.baeldung.com/spring-boot-custom-error-page for inspiration)

#### Home page

The home page will display a list with all existing airports.
Each airport in the list will act as a link.
Clicking on such a link takes us to a new page which displays the airport details:

- name, city, country
- latitude, longitude (optionally graphically displayed in an integrated map,
  e.g. Google Maps, OpenStreetMap, MapBox),
  
and two lists:

- one list containing the next ten departures on the current date
- one list containing the next ten arrivals on the current date.

#### Search page by airport

We need a search page, where we can select an airport, a date interval and flight type (departure or arrival).
The search functionality will then display a list with all the flights on the selected airport for the given dates and flight type.

#### Search page by airline

We need a search page where we can select an airline and a date interval.
The search functionality will then display the airline's flights on the given dates.

#### Administration page

The header will display a "Dashboard" link when an admin logs in.
That link allows the admin to access the administration page. That page allows us to add/edit/delete information about flights.

The page displays a table with all the flights we have in the database. Use pagination.
We have to be able to perform actions on each row in the table: edit, delete. For instance, we press "Edit" on one of the rows:
we see a new page containing a form, pre-filled with the flight information we want to edit. The page has a "Save" button.
Similarly, the "Delete" button deletes the record which we pressed it for.

On the top of the page we need an "Add" button. It will take us to a new page which displays a flight creation form.
The flight contains the following information:
- departure airport
- arrival airport (these two fields are dropdown lists which display the airports we have in the database)
- departure date and time
- arrival date and time
- airline (again, selected from a dropdown list)
- flight number

The `flights` table will look like this:
- `id` long PK
- `flight_no` string
- `departure` datetime
- `arrival` datetime
- `departure_airport_id` FK (foreign key; link to the airports table id)
- `arrival_airport_id` FK (foreign key; link to the airports table id)
- `airline_id` FK (foreign key; link to the airlines table id)

After we create a new flight, the application takes us back to the flights list.

We will insert the information about airports and airlines by script. Take the information you need from here:
- https://openflights.org/data.html
- https://ourairports.com/data/

#### Login & Register

The application should be secured using Spring Security (applying the things that we learned).
Therefore, the home page, and the search pages will be available to all users (even guests), but the administration
pages will only be available to authenticated users. Moreover, the administration pages can be accessed by users having
the `ADMIN` role.
Please design the `users` table according to the requirements.

Beside the necessary login page, please design and implement a register page, where a person can create an account.
When you look at the header as a guest you will see links to "Login" and "Register". After the user authenticates, these
two links are not visible anymore, and the "Logout" link is visible.

### Technical requirements

- create a private GitHub repository (add me as colaborator)
- set it up as a Maven project
- use Spring Boot 2.5.1
- organize your project using layers:
    - controller
    - model
    - service
    - repository
- implement integration tests using JUnit5 and Mockito
- write documentation in the `README.md` file, describing the necessary steps for installing and running the application,
e.g.:
    - how to set the database up
    - how to build the project and start the server (not from the IDE, but on command line, e.g. `mvn spring-boot:run`)  
    - how to access the application in the browser (e.g. given that you configured `hello` to be the application context
      you can type in `http://localhost:8080/hello`)