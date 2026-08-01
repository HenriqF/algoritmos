
# import sys

# def aura():
#     numero_um: int = 10

#     numero_dois: int = 20

#     print(numero_um, numero_dois, sep = " aura ", end = "\n\n\n\n\n\n\n\n\n")

#     print(numero_dois, numero_um, sep = " aura ", end = "\n\n\n\n\n\n\n\n\n")


# numero_um = 10
# print(numero_um)

# #THE BOOKISONTHETABLE!!!!

# print(type(numero_um))
# print(f"bytes: {sys.getsizeof(numero_um)}")

# numero_um = "Sixsevenildo"

# print(type(numero_um))
# print(f"bytes: {sys.getsizeof(numero_um)}")

# #aura()

# def e_par(valor):
#     if (valor & 1 == 0):
#         print(f"numero {valor} é par")
#     else:
#         print(f"numero {valor} é impar")


# e_par(4)
# e_par(3)

# for banana in range(0, 135, 67):
#     print(banana)

# for banana in range(1, 50, 2):
#     e_par(banana)

# for banana in range(0, 50, 2):
#     e_par(banana)

# numeros = [ n for n in range (0, 20)]
# for n in numeros:
#     print(n%2)


def somar():
    n1 = 3
    n2 = 4
    print(f"resultado da soma: {n1+n2}")

def somar_params(n1 , n2):
    print(n1+n2)

def somar_return(n1 = 67, n2 = 67):
    return n1+n2

somar()
somar_params("numero ", "+ numero")
print(somar_return("6", "7"))
print(somar_return())

total = somar_return(somar_return(2,2), somar_return(6,6))
print(f"valor: {total}, tipo:{type(total)}")

my_list = [1,2,True, 3,4,5,6, "labrador", 3.5, "cachorro"]
for n in my_list:
    print(n, end= " ")
print()


# print(my_list[2:4j])