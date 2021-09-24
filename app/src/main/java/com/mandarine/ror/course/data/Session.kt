package com.mandarine.ror.course.data

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
        timeInterval = "18:00-20:00",
        description = "Ruby Intro",
        imageUrl = "https://media-exp1.licdn.com/dms/image/C4D03AQFElJwdY2pzWw/profile-displayphoto-shrink_400_400/0/1577561303245?e=1637798400&v=beta&t=Xt9fLP8kM8bBnLlCRGnyG7SY0fTKAcu64YpV15ya2w0"
    ),
    Session(
        id = "2",
        speaker = "Daria Nikitenko",
        date = "29 June",
        timeInterval = "19:00-21:00",
        description = "Ruby Constructs",
        imageUrl = "https://media-exp1.licdn.com/dms/image/C4E03AQHJbY-WgG4wkg/profile-displayphoto-shrink_400_400/0/1611861938105?e=1637798400&v=beta&t=Gb15NxurL0u5ehx0eff1l9paf5_DkH2hEz9oHZAELOs"
    ),
    Session(
        id = "3",
        speaker = "Eugen Mocan",
        date = "29 June",
        timeInterval = "18:30-20:30",
        description = "Ruby Classes",
        imageUrl = "https://media-exp1.licdn.com/dms/image/C5603AQElF7rnXU-U9w/profile-displayphoto-shrink_400_400/0/1540318247202?e=1637798400&v=beta&t=4_jWrEkNhaWAjS4JFvSmAeHdnH2SKt_uSmTDNpFDWUI"
    ),
    Session(
        id = "4",
        speaker = "Olga Gorceag",
        date = "01 July",
        timeInterval = "19:00-21:00",
        description = "Dev Environment Setup",
        imageUrl = "https://media-exp1.licdn.com/dms/image/C5603AQEPS7Og9t_LUA/profile-displayphoto-shrink_400_400/0/1626295596720?e=1637798400&v=beta&t=4gvGuNaFirclKrovMAnW6x2YYSewGb6zQqmTVrGvMpE"
    ),
    Session(
        id = "5",
        speaker = "Error",
        date = "02 July",
        timeInterval = "19:00-21:00",
        description = "Handle errors",
        imageUrl = "error"
    )
)