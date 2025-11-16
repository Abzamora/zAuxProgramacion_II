from datetime import date
#la clase Padre
class Farmacia:
    def __init__(self, codigo: str, nombre: str):
        self.codigo = codigo
        self.nombre = nombre
    def __str__(self):
        return f'[{self.codigo}] {self.nombre}'

class RecetaMedica(Farmacia):
    def __init__(self, codigo:str, nombre:str, medico:str, fecha_emision:date, indicaciones:str):
        super().__init__(codigo,nombre)
        self.medico = medico
        self.fecha_emision = fecha_emision
        self.indicaciones = indicaciones
        self.lotes=[] #composicion, lote pertenece a receta
    def agregar_lote(self, lote):
        self.lotes.append(lote)
    def __str__(self):
        return f'Receta:{super().__str__()} | Dr. {self.medico} | {self.fecha_emision}'

class Medicamento(Farmacia):
    def __init__(self, codigo:str, nombre:str, principio_activo:str, dosis:str, forma_farmaceutica:str, precio_unitario:float):
        super().__init__(codigo,nombre)
        self.principio_activo = principio_activo
        self.dosis = dosis
        self.forma_farmaceutica = forma_farmaceutica
        self.precio_unitario = precio_unitario
        self.lotes = [] #agrega, lote puede esta en medicamentos
    def __str__(self):
        return f'Medi: {super().__str__()} | {self.principio_activo} | {self.dosis} | {self.forma_farmaceutica}'

class Lote:
    def __init__(self, numero_lote:str, fecha_vencimiento:date, cantidad_inicial:int):
        self.numero_lote = numero_lote
        self.fecha_vencimiento = fecha_vencimiento
        self.cantidad_inicial = cantidad_inicial
        self.cantidad_actual = cantidad_inicial
        self.registros=[] #compone. registro pertenece a lote
    def agregar_registro(self, registro):
        self.registros.append(registro)
        if registro.tipo_operacion == "salida":
            self.cantidad_inicial -= registro.cantidad
        elif registro.tipo_operacion == "entrada":
            self.cantidad_inicial += registro.cantidad
    def __str__(self):
        return f'Lote {self.numero_lote} | Vence: {self.fecha_vencimiento} | Stock: {self.cantidad_actual}/{self.cantidad_inicial}'

class Registro:
    def __init__(self, id_registro:int, fecha_movimiento:date, cantidad:int, tipo_operacion:str):
        self.id_registro = id_registro
        self.fecha_movimiento = fecha_movimiento
        self.cantidad = cantidad
        self.tipo_operacion = tipo_operacion
    def __str__(self):
        return f'Reg#{self.id_registro} | {self.fecha_movimiento} | {self.tipo_operacion.upper()} {self.cantidad}u'

if __name__ == '__main__':
    print('/*/*/* Sistema de farmacia - Brandon /*/*/*\n')
    receta = RecetaMedica("RED-001", "Receta Antibiotico", "Lopez", date(2025, 11, 15), "i cad 8h x 7 dias")
    medicamento = Medicamento("MED-001", "Amoxicilina 500mg", "Amoxicilina", "500mg", "Capsula",2.50)
    lote_receta = Lote("LOT-R01", date(2027, 6, 30), 50)
    lote_medicamento = Lote("LOT-M01", date(2027, 12, 31), 200)
    receta.agregar_lote(lote_receta) # asociacion
    medicamento.lotes.append(lote_medicamento)
    lote_receta.agregar_registro(Registro(1, date(2025, 11, 16), 50, "entrada"))  # Registros
    lote_receta.agregar_registro(Registro(2, date(2025, 11, 16), 10, "salida"))
    lote_medicamento.agregar_registro(Registro(3, date(2025, 11, 16), 200, "entrada"))
    lote_medicamento.agregar_registro(Registro(4, date(2025, 11, 16), 30, "salida"))
    print(receta) #mostrar
    for lote in receta.lotes:
        print(f"  {lote}")
        for reg in lote.registros:
            print(f"  {reg}")
    print("\n" + "-" * 50)
    print(medicamento)
    for lote in medicamento.lotes:
        print(f"  {lote}")
        for reg in lote.registros:
            print(f"    {reg}")