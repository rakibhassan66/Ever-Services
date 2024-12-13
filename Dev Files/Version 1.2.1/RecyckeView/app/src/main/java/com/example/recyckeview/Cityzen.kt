package com.example.recyclerview

class Cityzen {
    var name: String = ""
    var id: String = ""
    var classname: String = ""
    var image: Int = 0

    // Default (no-argument) constructor
    constructor()

    // Parameterized constructor
    constructor(name: String, id: String, classname: String, image: Int) {
        this.name = name
        this.id = id
        this.classname = classname
        this.image = image
    }
}