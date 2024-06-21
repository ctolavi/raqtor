import requests

# ============================== Create tournaments ==============================
url = 'http://localhost:8080/tournaments'
tournament = {
    "name": " CAMPEONATO NACIONAL DE RAQUETBOL OPEN A-B-C-D SUCRE"
}
requests.post(url, json=tournament)
tournamentsResponse = requests.get(url)
print("===== tournaments =====")
print(tournamentsResponse.text)

# ============================== Create Clubs ==============================
url = 'http://localhost:8080/clubs'
clubs =[
    {"name": "CHQ"},
    {"name": "SCZ"},
    {"name": "CBA"},
    {"name": "LPZ"},
    {"name": "ORU"},
]
for club in clubs:
    x = requests.post(url, json=club)
clubsResponse = requests.get(url)
print("===== clubs =====")
print(clubsResponse.text)

# ============================== Create players ==============================
url = 'http://localhost:8080/players'
players = [
    # A
    {"name": "Conrrado Kevin", "surnames": "Moscoso Ortiz"},
    {"name": "Jheffrey Richard", "surnames": "Oxachoque Tito"},
    {"name": "Brayan", "surnames": "Zambrana"},
    {"name": "Pablo", "surnames": "Lagos Asturizaga"},
    {"name": "Ramiro", "surnames": "Echalar"},
    # B
    {"name": "Carlos", "surnames": "Keller"},
    {"name": "Matias", "surnames": "Arnez"},
    {"name": "Juan Pablo", "surnames": "Rocabado"},
    {"name": "Josue Emiliano", "surnames": "Farfan Enriquez"},
    # C
    {"name": "Kadim", "surnames": "Carrasco"},
    {"name": "Carlos Andres", "surnames": "Moscoso Ortiz"},
    {"name": "Sebastian", "surnames": "Garabito Fuertes"},
    {"name": "Santiago", "surnames": "Borja"},
    # D
    {"name": "Nicolas", "surnames": "Iglesias"},
    {"name": "Esteban", "surnames": "Reque Zambrana"},
    {"name": "Mario", "surnames": "Mercado"},
    {"name": "Gerardo", "surnames": "Cahuana"},
    # E
    {"name": "Marco Antonio", "surnames": "Vedia Rosales"},
    {"name": "Anduari", "surnames": "Segundo"},
    {"name": "David", "surnames": "Echalar"},
    {"name": "Javier", "surnames": "Farfan Enriquez"}
]

for player in players:
    x = requests.post(url, json=player)

playersResponse = requests.get(url)
print("===== players =====")
print(playersResponse.text)

# ============================== Add players to a club ==============================
url = 'http://localhost:8080/clubs/1/players'
player_clubs = [
    {"id": 1},
    {"id": 3},
    {"id": 5},

    {"id": 8},
    {"id": 9},

    {"id": 11},
    {"id": 12},

    {"id": 14},
    {"id": 17},

    {"id": 18},
    {"id": 20}
]
for player_club in player_clubs:
    x = requests.post(url, json=player_club)
playersResponse = requests.get(url)
print("===== players with club 1 =====")
print(playersResponse.text)

url = 'http://localhost:8080/clubs/2/players'
player_clubs = [
    {"id": 6, "clubId": 2},
    {"id": 19, "clubId": 2}
]
for player_club in player_clubs:
    x = requests.post(url, json=player_club)
playersResponse = requests.get(url)
print("===== players with club 2 =====")
print(playersResponse.text)

url = 'http://localhost:8080/clubs/3/players'
player_clubs = [
    {"id": 7},
    {"id": 13},
    {"id": 16},
    {"id": 21}
]
for player_club in player_clubs:
    x = requests.post(url, json=player_club)
playersResponse = requests.get(url)
print("===== players with club 3 =====")
print(playersResponse.text)

url = 'http://localhost:8080/clubs/4/players'
player_clubs = [
    {"id": 4},
    {"id": 10},
    {"id": 15}
]
for player_club in player_clubs:
    x = requests.post(url, json=player_club)
playersResponse = requests.get(url)
print("===== players with club 4 =====")
print(playersResponse.text)

url = 'http://localhost:8080/clubs/5/players'
player_clubs = [
    {"id": 2}
]
for player_club in player_clubs:
    x = requests.post(url, json=player_club)
playersResponse = requests.get(url)
print("===== players with club 5 =====")
print(playersResponse.text)


# ============================== Add players to a club ==============================
url = 'http://localhost:8080/categories'
categories = [
    {"name": "Varones Open", "shortName": "VO"}
]
for category in categories:
    x = requests.post(url, json=category)
categoriesResponse = requests.get(url)
print("===== categories =====")
print(categoriesResponse.text)


# ============================== Add categories to a tournament ==============================
url = 'http://localhost:8080/tournaments/1/categories'
category = {"id": 1}
x = requests.post(url, json=category)
categoriesResponse = requests.get(url)
print("===== categories in tournament 1 =====")
print(categoriesResponse.text)