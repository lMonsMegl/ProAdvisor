import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import ReactFlagsSelect from 'react-flags-select';
import 'react-flags-select/css/react-flags-select.css';
import 'react-flags-select/scss/react-flags-select.scss';
import { changeLanguage } from '../actions/store/languages';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import logo from '../assets/logo.png';
import LogInModal from './modals/LogInModal';

class AppHeader extends Component {
  static propTypes = {
    menuData: PropTypes.objectOf(PropTypes.object),
    name: PropTypes.string,
    switchLanguage: PropTypes.func,
    signIn: PropTypes.func,
    registerIn: PropTypes.func
  };

  constructor(props) {
    super(props);
    this.state = {
      active: '',
      registerModal: false,
      name: ''
    };
  }

  registerModal = () => {
    const show = this.state.registerModal;
    this.setState({ registerModal: !show });
  };

  render() {
    const { switchLanguage, menuData } = this.props;

    return (
        <div className="header">

            <Link to="/home">
              <div>
                <img alt="" src={logo} />
              </div>
            </Link>

            <Link to="/catalog" style={{ textDecoration: 'none' }}>
              {/*<div>*/}
              {/*    <i className="fas fa-search fa-half" />*/}
              {/*  {menuData.HEADER.SEARCH}*/}
              {/*</div>*/}
            </Link>

          {
            this.props.name === '' ?
                <button
                    type="button"
                    className="register-button"
                    data-toggle="modal"
                    data-target="#logInModal"
                    onClick={this.registerModal}>
                  <div><i className="fas fa-plus-square fa-half" /></div>
                  {menuData.HEADER.PUBLISH}
                </button> :
                <Link to="/add-item" style={{ textDecoration: 'none' }}>
                  <div>
                    <div><i className="fas fa-plus-square fa-half" /></div>
                    {menuData.HEADER.PUBLISH}
                  </div>
                </Link>
          }

            <Link to="/catalog" style={{ textDecoration: 'none' }}>
              <div>
                <div><i className="far fa-address-book fa-half" /></div>
                {menuData.HEADER.CATALOG}
              </div>
            </Link>

          <div className="header-item">
            <button
                type="button"
                className="register-button"
                data-toggle="modal"
                data-target="#logInModal"
                onClick={this.registerModal}>
              <i className="far fa-user fa-half" />
              {this.props.name === '' ? menuData.HEADER.LOG_IN : this.props.name}
            </button>
          </div>


          <div className="header-item">
            <ReactFlagsSelect
                onSelect={(lang) => switchLanguage(lang)}
                defaultCountry="GB"
                className="menu-flags"
                countries={['GB', 'RU', 'UA']}
                customLabels={{ 'GB': 'EN', 'RU': 'RU', 'UA': 'UA' }} />
          </div>
          <LogInModal />
        </div>
    );
  }
}

const mapStateToProps = store => ({
  menuData: store.languages.menuData,
  name: store.user.username
});

const mapDispatchToProps = dispatch => ({
  switchLanguage: language => dispatch(changeLanguage(language))
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(AppHeader);
