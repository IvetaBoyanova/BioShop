import React from 'react';
import withStyles from '@material-ui/core/styles/withStyles';
import TopBar from './TopBar/'

const Styles = (theme: any) => ({
   root: {
      width: '100%',
      zIndex: 1
   },
   flex: {
      flex: 1
   },
   content: {
      height: 'calc(100% - 64px)',
      width: '100%',
      marginTop: '64px',
      position: 'fixed'
   },
   drawerPaper: {
      width: 250,
      [theme.breakpoints.up('md')]: {
         width: 240,
         zIndex: 0,
      },
   },
   drawerHeader: {
      [theme.breakpoints.up('md')]: theme.mixins.toolbar
   },
   logo: {
      [theme.breakpoints.down('sm')]: {
         display: 'block',
         margin: '0 auto'
      }
   }
});

const RootComponent = (props: any) => {
   const { classes, cartProducts, handleDrawer, menuIconCounter, handlePopOver, PopOverOpen, AnchorEl, cartBtn, handleClickMenu, menuAnchorEl, menuSelectedIndex } = props
   const badgeContent = cartProducts.cartItemsCount > 0 ? cartProducts.cartItemsCount : null;
   return (
      <div className={classes.root}>
         <TopBar
            classes={classes}
            badgeContent={badgeContent}
            menuIconCounter={menuIconCounter}
            handleDrawer={handleDrawer}
            cartProducts={cartProducts}
            handlePopOver={handlePopOver}
            PopOverOpen={PopOverOpen}
            AnchorEl={AnchorEl}
            cartBtn={cartBtn}
            handleClickMenu={handleClickMenu}
            menuAnchorEl={menuAnchorEl}
            menuSelectedIndex={menuSelectedIndex}/>
         <div className={classes.content}>
            {
               props.children
            }
         </div>
      </div>
   )
};

export default withStyles(Styles as any, { withTheme: true })(RootComponent)