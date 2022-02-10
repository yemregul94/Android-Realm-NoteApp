package com.works.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NoteModel : RealmObject() {

    @PrimaryKey
    var noteID: String = ""

    var noteText: String = ""

}

