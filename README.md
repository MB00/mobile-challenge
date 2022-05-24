## Build tools & versions used
Build tools version is 30.0.3, as denoted in build.gradle

## Steps to run the app
Nothing out of the ordinary is required here.  Just press the run button!

## What areas of the app did you focus on?
I spent most of my time attempting to build a solid architectural foundation, in order to ensure
the app is easily scalable and extensible.

## What was the reason for your focus? What problems were you trying to solve?
A proper architecture is the foundation of any production application, and the most difficult aspect
to change once development is underway.  A solid architecture ensures that engineers can spent
more on development rather than fighting against constraints in the codebase.

## How long did you spend on this project?
10-15 hours

## Did you make any trade-offs for this project? What would you have done differently with more time?
I used an Activity for the main screen in this project, because it allowed for slightly faster 
development, and because I didn't see any need to use Fragments at this point (as the
instructions for this project said to focus on the problem at hand).  With more time, it may have
made sense to implement Fragments with Jetpack Navigation, as that would probably prove useful as 
the app scope expands and more screens are added.  With more time, I would have also considered
utilizing Jetpack Compose to build the UI.  I've not super familiar with it yet, so I opted to use
XML instead.

## What do you think is the weakest part of your project?
Definitely the unit tests.  They were the last thing I worked on, and I ran out of time whilst
trying to finish them.

## Did you copy any code or dependencies? Please make sure to attribute them here!
No

## Is there any other information you’d like us to know?
No