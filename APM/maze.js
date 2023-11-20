var perdant = faux; // si l'utilisateur a heurté un mur

window.onload = fonction() {
    $("start").onclick = startClick;
    $("end").onmouseover = overEnd;
    var limites = $$("div#maze div.boundary");
    pour (var i = 0; i < limites.longueur; i++) {
        frontières[i].onmouseover = overBoundary;
    }
} ;

fonction overBoundary() {
    perdant = vrai ;
    var limites = $$("div#maze div.boundary");
    pour (var i = 0; i < limites.longueur; i++) {
        limites[i].addClassName("vous perdez");
    }
}

fonction startClick() {
    perdant = faux ;
    var limites = $$("div#maze div.boundary");
    pour (var i = 0; i < limites.longueur; i++) {
        limites[i].removeClassName("vous perdez");
    }
}

fonction overEnd() {
    si (perdant) {
        alert("Désolé, vous avez perdu. :[");
    } autre {
        alert("Vous gagnez ! :]");
    }
}