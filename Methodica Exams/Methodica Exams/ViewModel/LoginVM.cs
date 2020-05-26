using Methodica_Exams.Model;
using Methodica_Exams.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methodica_Exams.ViewModel
{
    public class LoginVM : INotifyPropertyChanged
    {
        public usuarios UsuarioLogueado { get; set; }

        public event PropertyChangedEventHandler PropertyChanged;

        public LoginVM()
        {
        }

        public bool ExisteUsuario(string username)
        {
            return BBDDService.usuarioExiste(username);
        }

        public bool Autenticar(string username,string password)
        {
            usuarios u = new usuarios();
            bool autenticado = false;

            if (ExisteUsuario(username))
            {
                u = BBDDService.getUsuario(username);

                autenticado = BCrypt.Net.BCrypt.Verify(password, u.password);

                if (autenticado)
                    UsuarioLogueado = u;
            }

            return autenticado;
        }
        


    }
}
