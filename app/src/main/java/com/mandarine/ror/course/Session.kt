package com.mandarine.ror.course

data class Session(
    val id: String,
    val speaker: String,
    val date: String,
    val timeInterval: String,
    val description: String,
    val imageUrl: String,
)

val MockSessions = listOf(
    Session(
        id = "1",
        speaker = "Andrei Lisnic",
        date = "28 June",
        timeInterval = "19:00-21:00",
        description = "Ruby Intro",
        imageUrl = "https://media-exp3.licdn.com/dms/image/C4D03AQFElJwdY2pzWw/profile-displayphoto-shrink_800_800/0/1577561303245?e=1629936000&v=beta&t=OUHwjBbUCjAK1FjkrJUE3WwZ2P43OmqvuAN_cig8rJQ"
    ),
    Session(
        id = "2",
        speaker = "Daria Nichitenco",
        date = "29 June",
        timeInterval = "19:00-21:00",
        description = "Ruby Constructs",
        imageUrl = "https://media-exp3.licdn.com/dms/image/C4E03AQHJbY-WgG4wkg/profile-displayphoto-shrink_800_800/0/1611861938105?e=1629936000&v=beta&t=l6IqW6x1YCnWWbaG7_gu5ch7HnMkE9EN_hdxEIy3Clo"
    ),
    Session(
        id = "3",
        speaker = "Eugen Mocan",
        date = "29 June",
        timeInterval = "19:00-21:00",
        description = "Ruby Classes",
        imageUrl = "https://media-exp3.licdn.com/dms/image/C5603AQElF7rnXU-U9w/profile-displayphoto-shrink_800_800/0/1540318247202?e=1629936000&v=beta&t=78a6r7QeE6_hVgKO8ke5Rmrsr71lMZ11aKZUFk1WGJc"
    ),
    Session(
        id = "4",
        speaker = "Olga Gorceag",
        date = "01 July",
        timeInterval = "19:00-21:00",
        description = "Dev Environment Setup",
        imageUrl = "https://media-exp3.licdn.com/dms/image/C4D03AQEb7hWJGVJk0w/profile-displayphoto-shrink_800_800/0/1620825152020?e=1629936000&v=beta&t=ABymvdUb_zuzPrXyQi-GXrQ37unP79dD1ThWn2HICIs"
    )
)