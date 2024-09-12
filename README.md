Inital set up of a RestAPI for an app I am creating, using Java Spring Boot & Maven as the build tool & postgres as the database. Set up using DTO pattern.

This is the basic set up of the API as initial test to get a base to work from, I am currently learning about Spring Security (hence this being commented out) to secure the API and will update how user log in and registration is handled so that this is secure.

Generated user story I will be working to, (created using chatGPT)

User Story: Dog Walk Logging, Restaurant Review, and Community Interaction Website
As a user,
I want to log and share my dog walks and restaurant experiences,
So that I can keep track of my routes, times, and ratings, while also exploring and interacting with walks and reviews from other users.

Acceptance Criteria:
User Registration and Login

As a user, I want to create an account with my email and password, so I can securely log in and access my personal dog walk records and interact with other users' posts.
As a returning user, I want to be able to log in using my credentials to view and manage my previous walks and engage with the community.
Walk Logging

As a user, I want to input the details of my dog walk, including the route taken (via a map feature or GPS), so I can save the exact path for future reference.
I want to specify how long my walk took by either manually entering the duration or having it automatically calculated.
I want to assign a rating (out of 5 stars) to the walk based on my overall experience, so I can easily compare walks later.
Restaurant Upload

As a user, I want to add details about any restaurant I visited during or after my walk, including the name, location, and my review of the food and service, so I can keep track of places I enjoyed or didn’t enjoy.
I want to rate the restaurant separately from the walk rating (out of 5 stars) to maintain clear distinctions between the two experiences.
Walk and Restaurant Review History

As a user, I want to be able to view a history of all my logged walks, along with their associated restaurants, ratings, and routes, so I can revisit or compare past experiences.
I want to filter my walks by location, rating, or time duration, so I can easily find specific entries.
Search for Walks and Restaurants

As a user, I want to search for dog walks that other users have logged based on location, rating, or duration, so I can discover new routes to try with my dog.
I also want to search for restaurants that have been reviewed by other users, so I can find dog-friendly or recommended places to eat along my walks.
Rate and Comment on Other Users’ Walks and Restaurants

As a user, I want to be able to view the details of walks and restaurants posted by other users, including their routes, duration, and reviews.
I want to give my own rating (out of 5 stars) and leave comments on their walks and restaurants, so I can share my thoughts or feedback.
I also want to see the overall community rating for each walk and restaurant, so I can gauge how popular or well-reviewed they are.
Interactive Map Integration

As a user, I want to visualize the routes of walks (mine and others) on an interactive map, so I can easily see geographical details and decide which routes to try.
I also want to see restaurant locations pinned on the same map to help plan my walk and dining stops.
Mobile-Friendly Experience

As a user, I want to have a seamless experience using the website on both desktop and mobile devices, so I can easily log and search for walks and restaurants while I’m out.
Social Sharing (Optional)

As a user, I want the option to share my logged walks and restaurant experiences on social media platforms, so my friends can see and engage with my posts.
User Community Features

As a user, I want to be able to follow other users whose walks and restaurant reviews I find useful, so I can stay updated on their posts.
I also want to be notified when someone comments on or rates my posts, so I can engage with the community.