package com.example


object EndPoints {
    const val ROOT = "/"
    const val USER = "/user"
    object User {
        const val ALICE = "$USER/alice"
        const val BOB = "$USER/bob"
    }

    const val CAR = "/car"
}
