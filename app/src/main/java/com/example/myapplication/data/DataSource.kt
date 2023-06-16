package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Topic

class DataSource() {
    fun loadTopics(): List<Topic> {
        return listOf<Topic>(
            Topic(R.string.architecture, 58, R.drawable.img1),
            Topic(R.string.crafts, 121, R.drawable.img2),
            Topic(R.string.business, 78, R.drawable.img3),
            Topic(R.string.culinary, 118, R.drawable.img4),
            Topic(R.string.design, 423, R.drawable.img5),
            Topic(R.string.fashion, 92, R.drawable.img6),
            Topic(R.string.film, 165, R.drawable.img7),
            Topic(R.string.gaming, 164, R.drawable.img8),
            Topic(R.string.drawing, 326, R.drawable.img9),
            Topic(R.string.lifestyle, 305, R.drawable.img1),
            Topic(R.string.music, 212, R.drawable.img2),
            Topic(R.string.painting, 172, R.drawable.img3),
            Topic(R.string.photography, 321, R.drawable.img4),
            Topic(R.string.tech, 118, R.drawable.img5)
        )
    }
}
