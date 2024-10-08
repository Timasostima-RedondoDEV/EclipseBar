package structure

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

var lang by mutableStateOf("en")

private val langPack = mapOf(
    "es" to mapOf(
        "Charge" to "Cobrar",
        "Erase" to "Borrar",
        "No products" to "No hay productos",
        "Enter the amount" to "Introduce el importe",
        "Not enough money" to "Dinero insuficiente",
        "Change" to "Cambio",
        "unit" to "unidad",
        "All" to "Todos",
        "Sodas" to "Refrescos",
        "Cocktails" to "Cócteles",
        "Food" to "Comida",
        "Not in stock" to "No hay en stock",
        "Total" to "Total",
        "POS App" to "Aplicacion TPV",
        "Name" to "Nombre",
        "Password" to "Contraseña",
        "Incorrect username or password" to "Usuario o contraseña incorrectos",
        "Software developed by Tymur Kulivar and Javier Redondo" to "Sofware desarrollado por Tymur Kulivar y Javier Redondo",
        "History" to "Historial",
        "Stock" to "Stock",
        "Main menu" to "Menú principal",
        "Close" to "Cerrar",
        "Number" to "Número",
        "Date" to "Fecha",
        "Time" to "Hora",
        "Waiter" to "Camarero",
        "Filters" to "Filtros",
        "Order number" to "Número pedido",
        "Min" to "Min",
        "Max" to "Max",
        "Amount" to "Importe",
        "Apply" to "Aplicar",
        "Reset" to "Resetear",
        "Start date" to "Fecha inicio",
        "End date" to "Fecha fin",
        "Login" to "Iniciar sesión",
        "Add product" to "Añadir producto",
        "RRP" to "PVP",
        "Cancel" to "Cancelar",
        "Save" to "Guardar",
        "Confirm" to "Confirmar",
        "Category" to "Categoría",
        "Price" to "Precio",
        "Search" to "Buscar",
        "Are you sure?" to "¿Estás seguro?",
    ),
    "ru" to mapOf(
        "Charge" to "Заплатить",
        "Erase" to "Стереть",
        "No products" to "Недостаточно продуктов",
        "Enter the amount" to "Введите сумму",
        "Not enough money" to "Недостаточно денег",
        "Change" to "Сдача",
        "unit" to "единица",
        "All" to "Все",
        "Sodas" to "Газировка",
        "Cocktails" to "Коктейли",
        "Food" to "Еда",
        "Not in stock" to "Нет в наличии",
        "Total" to "Итого",
        "POS App" to "Цифровая касса",
        "Name" to "Имя",
        "Password" to "Пароль",
        "Incorrect username or password" to "Неверное имя пользователя или пароль",
        "Software developed by Tymur Kulivar and Javier Redondo" to "Программное обеспечение разработано Тимуром Куливаром и Хавьером Редондо",
        "History" to "История",
        "Stock" to "Склад",
        "Main menu" to "Главное меню",
        "Close" to "Закрыть",
        "Number" to "Номер",
        "Date" to "Дата",
        "Time" to "Время",
        "Waiter" to "Официант",
        "Filters" to "Фильтры",
        "Order number" to "Номер заказа",
        "Min" to "Мин",
        "Max" to "Макс",
        "Amount" to "Сумма",
        "Apply" to "Применить",
        "Reset" to "Сбросить",
        "Start date" to "Дата начала",
        "End date" to "Дата окончания",
        "Login" to "Войти",
        "Add product" to "Добавить продукт",
        "RRP" to "РЦП",
        "Cancel" to "Отмена",
        "Save" to "Сохранить",
        "Confirm" to "Подтвердить",
        "Category" to "Категория",
        "Price" to "Цена",
        "Search" to "Поиск",
        "Are you sure?" to "Вы уверены?"
    )
)

fun getString(key: String): String {
    return langPack[lang]?.get(key) ?: key
}

fun langlist(): List<String> {
    return listOf("en") + langPack.keys.toList()
}