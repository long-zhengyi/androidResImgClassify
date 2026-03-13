package personal.lzy.androidres

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform