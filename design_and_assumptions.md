##Design

* The first iteration of the program consisted of Rover, Plateau and MissionControl classes

* The intention was to have MissionControl as the user interface, request a sequence of instructions for the rover objects to carry out on a single plateau object

* Soon extended out to Position, Coordinates and Heading objects (previously included as variables within Rover) to reduce the size and increase the modularity.

* There was also a lot of functionality around the Position that did not need to be included in the Rover class; the parsePosition method, for example.

* Further improvements might include the separation of the rover instructions and its associated methods into its own class, and even further into Move, Left and Right instruction subclasses.

* Also, it doesn’t seem necessary to have all of the position, coordinates and heading variables included in Rover. These dependencies could probably be reduced on refactoring.

* Additional improvements would include the separation of classes into separate packages. For example, Coordinates, Heading and Position into one package, Instruction classes (mentioned above) in another.

##Assumptions

“The problem below requires some kind of input.”

* I’ve assumed here that System.in is satisfactory.

“Specifically, you may use unit-testing libraries or build tools available for your chosen language”

* I’ve assumed JUnit, given as an example, is satisfactory.

“A squad of robotic rovers...“

“Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.”

* I’ve assumed that the rovers do not need to be instructed simultaneously at any point.

“A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points.”

"The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.”

* From this I’ve assumed that a rover, once deployed, will stay in its position or location until reinstructed. If there is no rover at the position and location specified, a new one is deployed. By that assumption, there can be up to four rovers at a given coordinate, pertaining to each of the cardinal compass points.

Input and Output detail

* I’ve assumed it is acceptable to provide additional system output for the purpose of user prompting, feedback and information
