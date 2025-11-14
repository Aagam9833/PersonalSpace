package com.aagamshah.data

val postsDummyJson = """
            {
  "posts": [
    {
      "id": 1,
      "username": "Aagam",
      "userProfileIcon": "https://loremfaces.net/24/id/2.jpg",
      "type": "image",
      "imageUrl": "https://picsum.dev/image/1277/view",
      "videoUrl": null,
      "caption": "Good food, good life!!",
      "likesCount": 4,
      "commentsCount": 1,
      "timestamp": 1763138023000,
      "comments": [
        {
          "id": 1,
          "username": "Anonymous",
          "userProfileIcon": "https://loremfaces.net/24/id/1.jpg",
          "comment": "Nice image",
          "commentLikesCount": 0,
          "timestamp": 1762943505000
        }
      ]
    },
    {
      "id": 2,
      "username": "Aagam",
      "userProfileIcon": "https://loremfaces.net/24/id/2.jpg",
      "type": "image",
      "imageUrl": "https://picsum.dev/image/1187/view",
      "videoUrl": "",
      "caption": "",
      "likesCount": 1,
      "commentsCount": 0,
      "timestamp": 1762943505000,
      "comments": [
      ]
    }
  ]
}
        """.trimIndent()