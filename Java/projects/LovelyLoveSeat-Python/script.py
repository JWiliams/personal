def add(message, watAdd2Mes):
    #message += watAdd2Mes + "\n"
    return message + watAdd2Mes

# Variables
lovLuvSDes = """
Lovely Loveseat. Tufted polyester blend on wood. 
32 inches high x 40 inches wide x 30 inches deep. Red or white.
"""
lovLuvPrice = 254.00
stylshSetDes = """
Stylish Settee. Faux leather on birch. 29.50 inches 
high x 54.75 inches wide x 28 inches deep. Black.
"""
stylshSetPrice = 180.50
luxLampDes = """
Luxurious Lamp. Glass and iron. 36 inches tall. Brown with 
cream shade.
"""
luxLampPrice = 52.15
sales_tax = .088
customerOneT = 0
customerOneD = ""
customerOneT += lovLuvPrice
customerOneD = add(customerOneD, lovLuvSDes)
customerOneT += luxLampPrice
customerOneD = add(customerOneD, luxLampDes)
print(customerOneD)