#### System Design

__1. Design a URL Shortening Service (TinyURL)__
* Given a long URL, the service should generate a shorter and unique alias of it.
* When the user hits a short link, the service should redirect to the original link.
* Consider scalability if 1000’s of URL shortening requests coming every second.
* Service handle redirects.
* Support for custom short URLs.
* Track click stats.
* Delete expired URLs.
* System should be highly available.

__Design YouTube/Netflix (a global video streaming service)__
* Approach to record stats about videos e.g the total number of views, up-votes/down-votes, etc.
* Adding comments on videos in real-time.

__Design Facebook Messenger or WhatsApp (a global chat service)__
* Approach for one-on-one text messaging between users.
* Approach for extending the design to support group chats.
* Delivered and read status
* What action needs to be taken if user is not connected to the internet.
* Push notifications
* Sending media like images or other documents
* Approach for providing end-to-end message encryption.

__Design Quora/Reddit/HackerNews (a social network + message board service)__
* Approach to record stats of each answer such as number of views, up-votes/down-votes, etc.
* Follow options should be there for users to follow other users or topics.
* News feed generation which means users can see the list of top questions from all the users and topics they follow on their timeline.

__Design Search Typeahead__
* Approach to store previous search queries
* Real time requirement of system
* Approach to keep the data fresh.
* Approach to find the best matches to the already typed string
* Queries per second to be handled by the system.
* Criteria for choosing the suggestions.
* Total number of data to be stored.
* Approach to find the best matches to the already typed string

__Design Dropbox/Google Drive/Google Photos (a global file storage and sharing service)__
* Approach to upload/view/search/share/download files or photos from any device.
* Service should support automatic synchronization between devices, i.e., after updating a file on one device, it should get synchronized on all devices.
* ACID (Atomicity, Consistency, Isolation and Durability) property should be present in the system.
* Approach to track permission for file sharing.
* Allowing multiple users to edit the same document.
* System should support storing large files up to a GB.

__Design a Web Crawler__
* Approach to find new web pages.
* Approach to prioritize web pages that change dynamically.
* Ensure that crawler is not unbounded on the same domain.

__Design Facebook, Twitter or Instagram__
* Some of the specific Twitter/Facebook/Instagram features to be supported.
* Privacy controls around each tweet or post.
* User should be able to post tweets also the system should support replies to tweets/grouping tweets by conversations.
* User should be able to see trending tweets/post.
* Direct messaging
* Mentions/Tagging.
* User should be able to follow another user.
* System should be able to handle the huge amount of traffic for billions of users.
* Number of followers
* Number of times the tweet has been favorited.

__Design Uber or lyft (a ride sharing service)__
* The backend is primarily serving mobile phone traffic. uber app talks to the backend over mobile data.
* How dispatch system works (GPS/ location data is what drive dispatch system)? How to efficiently match the user request with the nearby drivers?
* How do maps and routing works in Uber? How ETAs are calculated?
* An efficient approach to store millions of geographical locations for drivers/riders who are always on the move.
* Approach to handle millions of updates to driver location.
* Dispatch is mostly built using Node.js
* Services: Business logic services mostly written in python.
* Databases: Postgres, Redis, MySQL.

__Design an API Rate Limiter(Github)__
* Limiting the number of requests an entity can send to an API within a time window, for example, twenty requests per second.
* Rate limiting should work for a distributed setup, as the APIs are available through a group of servers.
* How to handle throttling (soft and hard throttling etc.).

__Design a messenger (e.g. Whatsapp)__


__Design a parking lot__

__How do you design the Vending Machine__

__How do you design a traffic control system__

__How to design a limit order book for trading systems__


__How to design Yelp or Nearby Friends__

__How to design BookMyShow__

__How do you design an Elevator of the Lift system__

__How would you go about designing an e-commerce website like Amazon or Flipcart at scale__

__How do you design a recommendation system__

