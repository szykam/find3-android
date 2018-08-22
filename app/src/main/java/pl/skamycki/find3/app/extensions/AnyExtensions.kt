package pl.skamycki.find3.app.extensions

inline fun <reified T> Any.takeIfInstance(): T? = if (this is T) this else null
