package com.sebastiancorradi.yape

class FakeApplication : YAPEApp() {
    companion object {
        private var instance = YAPEApp()

        fun getInstance(): YAPEApp {
            return instance
        }
    }
}