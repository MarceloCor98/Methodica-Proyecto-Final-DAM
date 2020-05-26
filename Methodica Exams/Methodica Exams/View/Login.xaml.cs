using Methodica_Exams.Model;
using Methodica_Exams.Services;
using Methodica_Exams.View;
using Methodica_Exams.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Methodica_Exams
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class Login : Window
    {
        public Login()
        {
            InitializeComponent();
            this.DataContext = new LoginVM();
            BBDDService.CargarBD();
        }

        private void IniciarSesionButton_Click(object sender, RoutedEventArgs e)
        {
            ErrorAuthTextBlock.Visibility = Visibility.Hidden;

            Autenticar();

        }

        private void Autenticar()
        {
            if ((this.DataContext as LoginVM).Autenticar(NombreUsuarioTextBox.Text,PasswordBox.Password))
            {

                if ((this.DataContext as LoginVM).UsuarioLogueado.roles.Contains("ROLE_ADMIN") ||
                    (this.DataContext as LoginVM).UsuarioLogueado.roles.Contains("ROLE_ALUMNO"))
                {
                    AlumnoVentana alumnoVentana = new AlumnoVentana((this.DataContext as LoginVM).UsuarioLogueado);
                    alumnoVentana.Show();
                }

                if ((this.DataContext as LoginVM).UsuarioLogueado.roles.Contains("ROLE_ADMIN") ||
                    (this.DataContext as LoginVM).UsuarioLogueado.roles.Contains("ROLE_PROFESOR"))
                {
                    ProfesorVentana profesorVentana = new ProfesorVentana((this.DataContext as LoginVM).UsuarioLogueado);
                    profesorVentana.Show();

                }

                Close();

            }else
                // Mensaje de error de autenticación
                ErrorAuthTextBlock.Visibility = Visibility.Visible;

        }
    }
}
