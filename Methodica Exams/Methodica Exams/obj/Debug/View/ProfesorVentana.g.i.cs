﻿#pragma checksum "..\..\..\View\ProfesorVentana.xaml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "3D3B99BC7DCE071629ED8436A15E9745D00D9AC8"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using Methodica_Exams.View;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace Methodica_Exams.View {
    
    
    /// <summary>
    /// ProfesorVentana
    /// </summary>
    public partial class ProfesorVentana : System.Windows.Window, System.Windows.Markup.IComponentConnector, System.Windows.Markup.IStyleConnector {
        
        
        #line 237 "..\..\..\View\ProfesorVentana.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListBox CursosProfeListBox;
        
        #line default
        #line hidden
        
        
        #line 258 "..\..\..\View\ProfesorVentana.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button CerrarSesionButton;
        
        #line default
        #line hidden
        
        
        #line 316 "..\..\..\View\ProfesorVentana.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ItemsControl TemasItemsControl;
        
        #line default
        #line hidden
        
        
        #line 374 "..\..\..\View\ProfesorVentana.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ItemsControl ExamenesParaCorregirItemsControl;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/Methodica Exams;component/view/profesorventana.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\View\ProfesorVentana.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.CursosProfeListBox = ((System.Windows.Controls.ListBox)(target));
            return;
            case 2:
            this.CerrarSesionButton = ((System.Windows.Controls.Button)(target));
            
            #line 258 "..\..\..\View\ProfesorVentana.xaml"
            this.CerrarSesionButton.Click += new System.Windows.RoutedEventHandler(this.CerrarSesionButton_Click);
            
            #line default
            #line hidden
            return;
            case 3:
            this.TemasItemsControl = ((System.Windows.Controls.ItemsControl)(target));
            return;
            case 8:
            this.ExamenesParaCorregirItemsControl = ((System.Windows.Controls.ItemsControl)(target));
            return;
            }
            this._contentLoaded = true;
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        void System.Windows.Markup.IStyleConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 4:
            
            #line 333 "..\..\..\View\ProfesorVentana.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.ActivarExamenButton_Click);
            
            #line default
            #line hidden
            break;
            case 5:
            
            #line 336 "..\..\..\View\ProfesorVentana.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.EliminarExamenButton_Click);
            
            #line default
            #line hidden
            break;
            case 6:
            
            #line 340 "..\..\..\View\ProfesorVentana.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.ConstruirExamenButton_Click);
            
            #line default
            #line hidden
            break;
            case 7:
            
            #line 355 "..\..\..\View\ProfesorVentana.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.AñadirExamenButton_Click);
            
            #line default
            #line hidden
            break;
            case 9:
            
            #line 392 "..\..\..\View\ProfesorVentana.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.CorregirExamenButton_Click);
            
            #line default
            #line hidden
            break;
            }
        }
    }
}

