//declaro funciones
function saludar(nombre) {
  return `¡Hola, ${nombre}! Bienvenido a Node.js`;
}

function despedir(nombre) {
  return `Adiós, ${nombre}. ¡Hasta pronto!`;
}

function otrafuncion(nombre) {
  return `No vuelvas , ${nombre}. ¡Hasta nunca!`;
}

// Exportar las funciones
module.exports = {
    otrafuncion,
  saludar,
  despedir
};


